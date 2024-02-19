/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package estga.poo.projetolp2;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author cravo
 */
class JogoDoGalo extends JFrame {

    private JPanel tabuleiroPanel, estatisticasPanel, botaoPanel, randomPanel;
    private JLabel textoEstatisticas, jogadorALabel, jogadorBLabel, empateLabel, jogosLabel, textoEspaco;
    private JButton[][] botoesTabuleiro = new JButton[3][3];
    private JButton novoJogoBotao;
    private int numeroJogos = 0;
    private int numeroJogosGanhosA = 0;
    private int numeroJogosGanhosB = 0;
    private int numeroJogosEmpatados = 0;
    private String jogadorA, jogadorB;
    private boolean turnoJogadorA = true;
    private boolean fimJogo = false;

    public JogoDoGalo() {

        super("Jogo do Galo");
        
        
        //inserir nomes jogadores
        jogadorA = JOptionPane.showInputDialog(this, "Digite o nome do jogador A:");
        jogadorB = JOptionPane.showInputDialog(this, "Digite o nome do jogador B:");
        
         if(jogadorA == null || jogadorA.trim().equals("")) {
            jogadorA = "Jogador A";
        }
        
        if(jogadorB == null || jogadorB.trim().equals("")) {
            jogadorB = "Jogador B";
        }
        
        JOptionPane.showMessageDialog(null, "Os jogadores são: " + jogadorA + " e " + jogadorB);
        
        // Painel do Tabuleiro
        tabuleiroPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoesTabuleiro[i][j] = new JButton("");
                botoesTabuleiro[i][j].setBackground(Color.WHITE);
                botoesTabuleiro[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                botoesTabuleiro[i][j].addActionListener(new JogadaListener());
                tabuleiroPanel.add(botoesTabuleiro[i][j]);
            }
        }

        // Painel das Estatísticas
        estatisticasPanel = new JPanel(new GridLayout(5, 2, 15, 1));
        estatisticasPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
        estatisticasPanel.setBounds(0, 0, 75, 75);
        textoEstatisticas = new JLabel("Estatísticas: ", (int) CENTER_ALIGNMENT);
        jogadorALabel = new JLabel(jogadorA + ": " + numeroJogosGanhosA + " (0%)");
        jogadorBLabel = new JLabel(jogadorB + ": " + numeroJogosGanhosB + " (0%)");
        empateLabel = new JLabel("Empates: " + numeroJogosEmpatados + " (0%)");
        jogosLabel = new JLabel("Jogos realizados: " + numeroJogos);
        estatisticasPanel.add(textoEstatisticas);
        estatisticasPanel.add(jogadorALabel);
        estatisticasPanel.add(jogadorBLabel);
        estatisticasPanel.add(empateLabel);
        estatisticasPanel.add(jogosLabel);

        // Painel do Botão Novo Jogo
        botaoPanel = new JPanel();
        novoJogoBotao = new JButton("Novo Jogo");
        novoJogoBotao.addActionListener(new NovoJogoListener());
        botaoPanel.add(novoJogoBotao);
        

        // Adicionar painéis à janela
        add(tabuleiroPanel, BorderLayout.CENTER);
        add(estatisticasPanel, BorderLayout.EAST);
        add(botaoPanel, BorderLayout.SOUTH);

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setBackground(Color.yellow);
    }

    // Listeners
    private class JogadaListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = (JButton) e.getSource(); // Verificar se o jogo já acabou
            if (fimJogo) {
                return;
            }

            // Obter o botão clicado e verificar se já foi marcado
            if (!botaoClicado.getText().equals("")) {
                return;
            }

            // Fazer a jogada e atualizar o tabuleiro
            if (turnoJogadorA) {
                botaoClicado.setText("X");
                botaoClicado.setForeground(Color.RED);
            } else {
                botaoClicado.setText("O");
                botaoClicado.setForeground(Color.BLUE);
            }
            turnoJogadorA = !turnoJogadorA;

            // Verificar se o jogo acabou
            if (verificarVitoria()) {
                JOptionPane.showMessageDialog(JogoDoGalo.this, "O Jogador " + (turnoJogadorA ? jogadorB : jogadorA) + " ganhou!");
                fimJogo = true;
                if (turnoJogadorA) {
                    numeroJogos++;
                    numeroJogosGanhosB++;
                } else {
                    numeroJogos++;
                    numeroJogosGanhosA++;
                }
            } else if (verificarEmpate()) {
                JOptionPane.showMessageDialog(JogoDoGalo.this, "Empate!");
                fimJogo = true;
                numeroJogosEmpatados++;
                numeroJogos++;
            }

            // Atualizar estatísticas
            jogadorALabel.setText(jogadorA + ": " + numeroJogosGanhosA + " (" + Math.round((double) numeroJogosGanhosA / numeroJogos * 100) + "%)");
            jogadorBLabel.setText(jogadorB + ": " + numeroJogosGanhosB + " (" + Math.round((double) numeroJogosGanhosB / numeroJogos * 100) + "%)");
            empateLabel.setText("Empates: " + numeroJogosEmpatados + " (" + Math.round((double) numeroJogosEmpatados / numeroJogos * 100) + "%)");
            jogosLabel.setText("Jogos realizados: " + numeroJogos);

        }

    }

    private class NovoJogoListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            novoJogo();
        }
    }

// Métodos auxiliares
    private boolean verificarVitoria() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (botoesTabuleiro[i][0].getText().equals(botoesTabuleiro[i][1].getText())
                    && botoesTabuleiro[i][1].getText().equals(botoesTabuleiro[i][2].getText())
                    && !botoesTabuleiro[i][0].getText().equals("")) {
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (botoesTabuleiro[0][j].getText().equals(botoesTabuleiro[1][j].getText())
                    && botoesTabuleiro[1][j].getText().equals(botoesTabuleiro[2][j].getText())
                    && !botoesTabuleiro[0][j].getText().equals("")) {
                return true;
            }
        }
        // Verificar diagonais
        if (botoesTabuleiro[0][0].getText().equals(botoesTabuleiro[1][1].getText())
                && botoesTabuleiro[1][1].getText().equals(botoesTabuleiro[2][2].getText())
                && !botoesTabuleiro[0][0].getText().equals("")) {
            return true;
        }

        if (botoesTabuleiro[0][2].getText().equals(botoesTabuleiro[1][1].getText())
                && botoesTabuleiro[1][1].getText().equals(botoesTabuleiro[2][0].getText())
                && !botoesTabuleiro[0][2].getText().equals("")) {
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botoesTabuleiro[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void novoJogo() {
        // Limpar o tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoesTabuleiro[i][j].setText("");
            }
        }

        // Atualizar as variáveis do jogo
        fimJogo = false;
        turnoJogadorA = true;

        // Atualizar o texto dos labels
        jogadorALabel.setText("Jogador A: " + numeroJogosGanhosA + " (" + Math.round((double) numeroJogosGanhosA / numeroJogos * 100) + "%)");
        jogadorBLabel.setText("Jogador B: " + numeroJogosGanhosB + " (" + Math.round((double) numeroJogosGanhosB / numeroJogos * 100) + "%)");
        empateLabel.setText("Empates: " + numeroJogosEmpatados + " (" + Math.round((double) numeroJogosEmpatados / numeroJogos * 100) + "%)");
        jogosLabel.setText("Jogos realizados: " + numeroJogos);
    }
}

// Método principal
public class ProjetoLP2 {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            FlatLightLaf.setup();
        } catch (Exception e) {
            System.out.println(e);
        }

        JogoDoGalo jogoDoGalo = new JogoDoGalo();
        jogoDoGalo.setVisible(true);
        jogoDoGalo.setBackground(Color.white);

    }
}
