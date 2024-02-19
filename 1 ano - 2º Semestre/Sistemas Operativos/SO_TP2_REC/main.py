import multiprocessing as mp
import random
from multiprocessing import Semaphore, Array


semaphore = Semaphore(1)
start_semaphore = Semaphore(0)  # Semáforo para sincronizar o início dos processos do cliente

def serverProcess(sharedNumbers, sharedStars, num_players):
    print("Server: Generating winning numbers...")
    winning_numbers = sorted(random.sample(range(1, 51), 5))
    winning_stars = sorted(random.sample(range(1, 13), 2))
    print("Server: Winning numbers:", winning_numbers)
    print("Server: Winning stars:", winning_stars)

    # Salvar as novas chaves vencedoras no arquivo winning_key.txt
    with open("winning_key.txt", "w") as file:
        file.write("Winning Numbers:\n")
        file.write(",".join(str(num) for num in winning_numbers))
        file.write("\n")
        file.write("Winning Stars:\n")
        file.write(",".join(str(star) for star in winning_stars))

        # Limpar os arquivos "mini_prize_winners.txt" e "jackpot_winners.txt"
        with open("mini_prize_winners.txt", "w") as file:
            pass  # Escrever uma string vazia para limpar o conteúdo
        with open("jackpot_winners.txt", "w") as file:
            pass  # Escrever uma string vazia para limpar o conteúdo

    # Sinalizar que os números vencedores foram gerados e os clientes podem começar
    start_semaphore.release()

    for player_num in range(num_players):
        semaphore.acquire()
        print("Player", player_num, ": Accessing the server")

        player_numbers = sharedNumbers[player_num * 5: player_num * 5 + 5]
        player_stars = sharedStars[player_num * 2: player_num * 2 + 2]

        # Criar arquivo para registrar os números do cliente
        filename = f"player_{player_num}_numbers.txt"


        with open(filename, "w") as file:
            file.write("Player Numbers:\n")
            file.write(",".join(str(num) for num in player_numbers))
            file.write("\n")
            file.write("Player Stars:\n")
            file.write(",".join(str(star) for star in player_stars))
        if player_numbers == winning_numbers and player_stars == winning_stars:
            print("Player", player_num, ": JACKPOT!")
            with open("jackpot_winners.txt", "a") as file:
                file.write(f"Player {player_num} - JACKPOT!\n")
        elif set(player_stars) == set(winning_stars):
            print("Player", player_num, ": Mini Prize!")
            with open("mini_prize_winners.txt", "a") as file:
                file.write("")
                file.write(f"Player {player_num} - Mini Prize!\n")
        else:
            print("Player", player_num, ": No win")

        print("Player", player_num, ": Leaving the server\n")
        semaphore.release()


def clientProcess(player_num):
    # Aguardar a liberação do semáforo para iniciar o processo do cliente
    start_semaphore.acquire()

    player_numbers = sorted(sharedNumbers[player_num * 5: player_num * 5 + 5])
    player_stars = sorted(sharedStars[player_num * 2: player_num * 2 + 2])

    # Ordenar os números do jogador em ordem crescente
    player_numbers.sort()
    player_stars.sort()

    # Criar arquivo para registrar os números do cliente
    filename = f"player_{player_num}_numbers.txt"

    semaphore.acquire()
    print("Player", player_num, ": Accessing the server")

    print("Player", player_num, ": Leaving the server\n")
    semaphore.release()


if __name__ == '__main__':
    num_players = int(input("Enter the number of clients: "))
    sharedNumbers = Array('i', [0] * (num_players * 5))
    sharedStars = Array('i', [0] * (num_players * 2))


    # Gere números e estrelas aleatórias para cada jogador
    for player_num in range(num_players):
        player_numbers = sorted(random.sample(range(1, 51), 5))
        player_stars = sorted(random.sample(range(1, 13), 2))

        # Atribua os números e estrelas do jogador aos arrays compartilhados
        for i, num in enumerate(player_numbers):
            sharedNumbers[player_num * 5 + i] = num
        for i, star in enumerate(player_stars):
            sharedStars[player_num * 2 + i] = star


    server = mp.Process(target=serverProcess, args=(sharedNumbers, sharedStars, num_players))
    server.start()

    client_processes = []
    for player_num in range(num_players):
        client = mp.Process(target=clientProcess, args=(player_num,))
        client.start()
        client_processes.append(client)

    for client in client_processes:
        client.join()

    server.join()
