package unicap.grafos.unicapmaps.dao;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Trajeto;

/**
 * Created by uira on 12/11/16.
 */

public class DadosTrajetosArestas{

    private static ArrayList<Trajeto> trajetos;

    public static void criarTrajetos(){
        trajetos = new ArrayList<>();
        trajetos.add(new Trajeto( 0,  1, A_B));
        trajetos.add(new Trajeto( 1,  0, B_A));
        trajetos.add(new Trajeto( 0,  3, A_D));
        trajetos.add(new Trajeto( 3,  0, D_A));
        trajetos.add(new Trajeto( 0,  4, A_E));
        trajetos.add(new Trajeto( 4,  0, E_A));
        trajetos.add(new Trajeto( 0,  5, A_F));
        trajetos.add(new Trajeto( 5,  0, F_A));
        trajetos.add(new Trajeto( 0,  6, A_G));
        trajetos.add(new Trajeto( 6,  0, G_A));
        trajetos.add(new Trajeto( 0, 17, A_R));
        trajetos.add(new Trajeto(17,  0, R_A));
        trajetos.add(new Trajeto( 0, 19, A_T));
        trajetos.add(new Trajeto(19,  0, T_A));
        trajetos.add(new Trajeto( 0, 20, A_U));
        trajetos.add(new Trajeto(20,  0, U_A));
        trajetos.add(new Trajeto( 0, 21, A_V));
        trajetos.add(new Trajeto(21,  0, V_A));
        trajetos.add(new Trajeto( 1,  2, B_C));
        trajetos.add(new Trajeto( 2,  1, C_B));
        trajetos.add(new Trajeto( 1, 15, B_P));
        trajetos.add(new Trajeto(15,  1, P_B));
        trajetos.add(new Trajeto( 2,  7, C_H));
        trajetos.add(new Trajeto( 7,  2, H_C));
        trajetos.add(new Trajeto( 2, 15, C_P));
        trajetos.add(new Trajeto(15,  2, P_C));
        trajetos.add(new Trajeto( 4,  5, E_F));
        trajetos.add(new Trajeto( 5,  4, F_E));
        trajetos.add(new Trajeto( 4,  6, E_G));
        trajetos.add(new Trajeto( 6,  4, G_E));
        trajetos.add(new Trajeto( 4,  7, E_H));
        trajetos.add(new Trajeto( 7,  4, H_E));
        trajetos.add(new Trajeto( 4,  8, E_I));
        trajetos.add(new Trajeto( 8,  4, I_E));
        trajetos.add(new Trajeto( 4, 17, E_R));
        trajetos.add(new Trajeto(17,  4, R_E));
        trajetos.add(new Trajeto( 4, 19, E_T));
        trajetos.add(new Trajeto(19,  4, T_E));
        trajetos.add(new Trajeto( 4, 20, E_U));
        trajetos.add(new Trajeto(20,  4, U_E));
        trajetos.add(new Trajeto( 5, 11, F_L));
        trajetos.add(new Trajeto(11,  5, L_F));
        trajetos.add(new Trajeto( 5, 13, F_N));
        trajetos.add(new Trajeto(13,  5, N_F));
        trajetos.add(new Trajeto( 5, 17, F_R));
        trajetos.add(new Trajeto(17,  5, R_F));
        trajetos.add(new Trajeto( 5, 18, F_S));
        trajetos.add(new Trajeto(18,  5, S_F));
        trajetos.add(new Trajeto( 5, 19, F_T));
        trajetos.add(new Trajeto(19,  5, T_F));
        trajetos.add(new Trajeto( 6, 12, G_M));
        trajetos.add(new Trajeto(12,  6, M_G));
        trajetos.add(new Trajeto( 6, 17, G_R));
        trajetos.add(new Trajeto(17,  6, R_G));
        trajetos.add(new Trajeto( 6, 18, G_S));
        trajetos.add(new Trajeto(18,  6, S_G));
        trajetos.add(new Trajeto( 6, 19, G_T));
        trajetos.add(new Trajeto(19,  6, T_G));
        trajetos.add(new Trajeto( 6, 21, G_V));
        trajetos.add(new Trajeto(21,  6, V_G));
        trajetos.add(new Trajeto( 6, 23, G_G4));
        trajetos.add(new Trajeto(23,  6, G4_G));
        trajetos.add(new Trajeto( 7,  8, H_I));
        trajetos.add(new Trajeto( 8,  7, I_H));
        trajetos.add(new Trajeto( 7, 15, H_P));
        trajetos.add(new Trajeto(15,  7, P_H));
        trajetos.add(new Trajeto( 8,  9, I_J));
        trajetos.add(new Trajeto( 9,  8, J_I));
        trajetos.add(new Trajeto(10, 11, K_L));
        trajetos.add(new Trajeto(11, 10, L_K));
        trajetos.add(new Trajeto(10, 14, K_O));
        trajetos.add(new Trajeto(14, 10, O_K));
        trajetos.add(new Trajeto(10, 22, K_W));
        trajetos.add(new Trajeto(22, 10, W_K));
        trajetos.add(new Trajeto(11, 13, L_N));
        trajetos.add(new Trajeto(13, 11, N_L));
        trajetos.add(new Trajeto(11, 22, L_W));
        trajetos.add(new Trajeto(22, 11, W_L));
        trajetos.add(new Trajeto(12, 21, M_V));
        trajetos.add(new Trajeto(21, 12, V_M));
        trajetos.add(new Trajeto(13, 14, N_O));
        trajetos.add(new Trajeto(14, 13, O_N));
        trajetos.add(new Trajeto(13, 19, N_T));
        trajetos.add(new Trajeto(19, 13, T_N));
        trajetos.add(new Trajeto(15, 20, P_U));
        trajetos.add(new Trajeto(20, 15, U_P));
        trajetos.add(new Trajeto(16, 20, Q_U));
        trajetos.add(new Trajeto(20, 16, U_Q));
        trajetos.add(new Trajeto(17, 19, R_T));
        trajetos.add(new Trajeto(19, 17, T_R));
        trajetos.add(new Trajeto(17, 21, R_V));
        trajetos.add(new Trajeto(21, 17, V_R));
        trajetos.add(new Trajeto(18, 19, S_T));
        trajetos.add(new Trajeto(19, 18, T_S));
    }

    public static ArrayList<Trajeto> getTrajetos() {
        criarTrajetos();
        return trajetos;
    }

    private static String[] A_B = {"Siga em direção ao Bloco B."};
    private static String[] B_A = {"Siga em direção ao Bloco A."};
    private static String[] A_D = {"Siga em direção ao Bloco D."};
    private static String[] D_A = {"Siga em direção ao Bloco A."};
    private static String[] A_E = {
            "Siga pelo corredor do Bloco A.",
            "Vire à direita ao sair do Bloco A.",
            "Ande até até a calçada e vire à esquerda.",
            "Vire à direita em direção ao Bloco E."
    };
    private static String[] E_A = {
            "Siga pela calçada e vire à esquerda.",
            "Siga pela calçada e vira à direta.",
            "Vire à esquerda no corredor e siga em direção ao Bloco A."
    };
    private static String[] A_F = {
            "Siga em direção à Rua do Lazer",
            "Vire à esquerda na Rua do Lazer",
            "Ao chegar na rua Afonso Pena, vire à direita.",
            "Siga em frente até chegar na rua Almeida Cunha.",
            "Siga em direção ao Bloco F."
    };
    private static String[] F_A = {
            "Siga pela rua Afonso Pena e atravesse a rua Almeida Cunha.",
            "Siga em frente até chegar na Rua do Lazer.",
            "Vire a esquerda na Rua do Lazer.",
            "Vire à direita em direção ao Bloco A."
    };
    private static String[] A_G = {
            "Siga em direção à Rua do Lazer",
            "Vire à esquerda na Rua do Lazer",
            "Ao chegar na rua Afonso Pena, vire à direita.",
            "Siga em frente até chegar na rua Almeida Cunha.",
            "Vire à direita em direção ao Bloco G."
    };
    private static String[] G_A = {
            "Siga em direção à rua Afonso Pena.",
            "Vire à esquerda e siga até a rua do Lazer.",
            "Siga pela rua do Lazer.",
            "Vire à direita em direção ao Bloco A."
    };
    // BLOCO R = 17
    private static String[] A_R = {
            "Siga em direção á Rua do Lazer.",
            "Vire à esquerda na Rua do Lazer.",
            "Vire à direita em direção ao Bloco R."
    };
    private static String[] R_A = {
            "Siga em direção à Rua do Lazer.",
            "Vire à esquerda na Rua do Lazer.",
            "Vire à direita em direção ao Bloco A."
    };
    private static String[] A_T = {
            "Siga em direção à Rua do Lazer.",
            "Vire à esquerda na Rua do Lazer.",
            "Na rua Afonso Pena, vire à direita.",
            "Siga pela rua Afonso Pena.",
            "Vire à esquerda em direção ao Bloco T"
    };
    private static String[] T_A = {
            "Atravesse a rua Afonso Pena",
            "Vire à direita em direção à rua do Lazer.",
            "Vire à esquerda na Rua do Lazer.",
            "Siga pela rua do lazer.",
            "Vire à direita em direção ao Bloco A."
    };
    private static String[] A_U = {
            "Siga pelo corredor do Bloco A.",
            "Vire à direita ao sair do Bloco A.",
            "Ande até até a calçada e vire à direita.",
            "Siga em direção ao à Quadra de esportes."
    };
    private static String[] U_A = {
            "Siga pela calçada e vire à esquerda.",
            "Vire à esquerda no corredor.",
            "Siga em direção ao Bloco A."
    };
    // 21
    private static String[] A_V = {
            "Siga em direção à Rua do Lazer.",
            "Vire à esquerda na Rua do Lazer.",
            "Vire à direita em direção ao corredor",
            "Vire à direita no caminho em direção ao Jardim"
    };
    private static String[] V_A = {
            "Siga pelo caminho em direção ao corredor.",
            "Vire à esquerda no corredor.",
            "Vire à esquerda na Rua do Lazer.",
            "Vire à direita em direção do Bloco A"
    };
    private static String[] B_C = {
            "Siga pelo corredor do bloco B.",
            "Vire à direita em direção ao Bloco C."
    };
    private static String[] C_B = {
            "Siga em direção ao corredor do Bloco B.",
            "Vire à direita em direção ao BLoco B."
    };
    private static String[] B_P = {"Siga em direção ao Estacionamento dos Funcionários."};
    private static String[] P_B = {"Siga em direção ao Bloco B."};
    private static String[] C_H = {"Siga em direção à Capela."};
    private static String[] H_C = {"Siga em direção ao Bloco C."};
    private static String[] C_P = {"Siga em direção ao Estacionamento dos Funcionários."};
    private static String[] P_C = {"Siga em direção ao Bloco C."};
    // 4 -> 5
    private static String[] E_F = {
            "Siga em direção à rua Afonso Pena.",
            "Vire à direita na rua Afonso Pena.",
            "Siga pela rua Afonso Pena.",
            "Atravesse a rua Bernando Guimarães.",
            "Continue pela rua Afonso Pena.",
            "Atravesse a rua Almeida Cunha",
            "Siga em direção ao Bloco F."
    };
    // 5-> 4
    private static String[] F_E = {
            "Siga pela rua Afonso Pena.",
            "Atravesse à rua Almeida Cunha.",
            "Continue pela rua Afonso Pena.",
            "Atravesse à rua Bernardo Guimarães.",
            "Vire à esquerda em direção ao Bloco E."
    };
    //4->6
    private static String[] E_G = {
            "Siga em direção à rua Afonso Pena.",
            "Vire à direita na rua Afonso Pena.",
            "Siga pela rua Afonso Pena.",
            "Atravesse a rua Bernando Guimarães.",
            "Continue pela rua Afonso Pena.",
            "Atravesse à esquerda na rua Almeida Cunha",
            "Siga em direção ao Bloco G."
    };
    //6->4
    private static String[] G_E = {
            "Siga pela rua Almeida Cunha em direção à rua Afonso Pena.",
            "Vire à equerda na rua Almeida Cunha.",
            "Siga pela rua Almeida Cunha.",
            "Atravesse a rua Bernardo Guimarães.",
            "Siga pela rua Almeida Cunha.",
            "Vire à esquerda em direção ao Bloco E."
    };
    // 4 -> 7
    private static String[] E_H = {
            "Siga em direção ao portão.",
            "Vire à esquerda em direção à Capela.",
    };
    // 7 -> 4
    private static String[] H_E = {
            "Siga em direção ao portão.",
            "Vire à direita em direção ao Bloco E."
    };
    //4->8
    private static String[] E_I = {
            "Siga em direção ao portão.",
            "Vire a direita em direção à rua do Príncipe.",
            "Atravesse a rua do Príncipe pela faixa de pedestres.",
            "Vire à direita em direção ao Bloco I."
    };
    //8->4
    private static String[] I_E = {
            "Siga em direção à faixa de pedestres da rua do Príncipe.",
            "Atravesse a rua do Príncipe pela faixa de pedestres.",
            "Vire à direita em direção ao portão.",
            "Vire à esquerda duas vezes em direção ao Bloco E."
    };
    //4->17
    private static String[] E_R = {
            "Siga em direção à rua Afonso Pena.",
            "Vire à direita na rua Afonso Pena.",
            "Siga até a rua do lazer.",
            "Vire à direita na rua do lazer.",
            "Siga pela rua do lazer até o primeiro portão.",
            "Vire à esquerda em direção ao Bloco R."
    };
    //17->4
    private static String[] R_E = {
            "Siga em direção à Rua do Lazer.",
            "Vire à direita na Rua do Lazer.",
            "Vire à esquerda na rua Afonso Pena.",
            "Siga pela rua Afonso Pena até o portão.",
            "Vire à esquerda em direção ao Bloco E"
    };
    //4->19
    private static String[] E_T = {
            "Siga em direção à rua Afonso Pena.",
            "Vire à direita na rua Afonso Pena.",
            "Atravesse a rua Bernardo Guimarães",
            "Siga pela rua Afonso Pena.",
            "Vire à esquerda em direção ao Bloco T."
    };
    //19->4
    private static String[] T_E = {
            "Atravesse a rua Afonso Pena.",
            "Vire à direita em direção à Rua do Príncipe.",
            "No portão, vire à esquerda em direção ao Bloco E."
    };
    //4->20
    private static String[] E_U = {
            "Siga pela calçada até o final do Bloco E.",
            "Vire à esquerda em direção à Quadra de esportes."
    };
    //20->4
    private static String[] U_E = {
            "Siga em direção à rua do Príncipe.",
            "Vire à direita em direção ao Bloco E"
    };
    //5->11
    private static String[] F_L = {
            "Atravesse a rua Afonso Pena.",
            "Vire à direita em direção ao Bloco L",
    };
    //11->5
    private static String[] L_F = {
            "Siga pela Afonso Pena em direção à rua Almeida Cunha.",
            "Vire à esquerda em direção ao Bloco F."
    };
    //5->13
    private static String[] F_N = {
            "Atravesse a rua Afonso Pena.",
            "Vire à esquerda em direção à rua Almeida Cunha.",
            "Vire à direita em direção ao Bloco N."
    };
    //13->5
    private static String[] N_F = {
            "Siga em direção a rua Afonso Pena.",
            "Vire à esquerda e direção à rua Eduardo de Carvalho.",
            "Vire à esquerda, e atravesse à rua Afonso Pena em direção ao Bloco F.",
    };
    //5->17
    private static String[] F_R = {
            "Siga pela rua Afonso Pena em direção à rua do lazer.",
            "Vire à esquerda na rua do lazer.",
            "Siga pela rua do lazer até o primeiro portão.",
            "Vire à esquerda em direção ao Bloco R."
    };
    //17->5
    private static String[] R_F = {
            "Siga pelo corredor em direção à rua do lazer.",
            "Vire à direita na rua do lazer.",
            "Vire à direita na rua Afonso Pena.",
            "Siga pela rua Afonso Pena e atravesse a rua Almeida Cunha.",
            "Siga em direção ao Bloco F"
    };
    //5->18
    private static String[] F_S = {
            "Siga em frente em direção à rua Almeida Cunha.",
            "Vire à esquerda na rua Almeida Cunha",
            "Siga em direção ao Estacionamento dos estudantes"
    };
    //18->5
    private static String[] S_F = {
            "Siga pela rua Almeida Cunha em direção à rua Afonso Pena.",
            "Vire à direita em direção ao Bloco F."
    };
    //5->19
    private static String[] F_T = {
            "Siga pela rua Afonso Pena e atravesse a rua Almeida Cunha.",
            "Siga em frente em direção à rua Bernardo Guimarães.",
            "Vire à direita e atravesse a rua Afonso Pena em direção ao Bloco T.",
    };
    //19->5
    private static String[] T_F = {
            "Atravesse a rua Afonso Pena.",
            "Vire à esquerda na rua Afonso Pena.",
            "Siga em frente e atravesse à rua Almeida Cunha.",
            "Siga em direção ao Bloco F."
    };
    //6->12
    private static String[] G_M = {
            "Vire à esquerda no corredor do Bloco G",
            "Vire à direita na segunda entrada do Jardim",
            "Siga pelo caminho do Jardim",
            "Vire levemente à esquerda em direção à Biblioteca."
    };
    //12->6
    private static String[] M_G = {
            "Vire levemente à direita pelo caminho do Jardim.",
            "Siga até o corredor do Bloco G.",
            "Siga pelo corredor do Bloco G.",
            "Vire à direita em direção à entrada do Bloco G."
    };
    //6->17
    private static String[] G_R = {
            "Vire levemente à direita seguindo em direção ao Bloco R.",
            "Vire levemente à esquerda em direção ao Bloco R."
    };
    //17->6
    private static String[] R_G = {
            "Siga em direção ao Bloco G.",
            "Vire levemente à direita em direção ao Bloco G.",
    };
    //6->18
    private static String[] G_S = {"Atravesse a rua Almeida Cunha em direção ao Estacionamento dos estudantes."};
    //18->6
    private static String[] S_G = {"Atravesse a rua Almeida Cunha em direção ao Bloco G."};
    //6->19
    private static String[] G_T = {
            "Siga pela rua Almeida Cunha em direção à rua Afonso Pena.",
            "Vire à esquerda na rua Afonso Pena.",
            "Siga em frente em direção a rua Bernardo Guimarães.",
            "Vire à direita e atravesse a rua em direção ao Bloco T"
    };
    //19->6
    private static String[] T_G = {
            "Atravesse a rua Afonso Pena.",
            "Vire à esquerda em direção a rua Almeida Cunha.",
            "Vire à direita em direção ao Bloco G.",
    };
    //6->21
    private static String[] G_V = {
            "Vire à esquerda no corredor do Bloco G.",
            "Vire à direita na primeira entrada do Jardim.",
            "Siga pelo caminho em direção ao Jardim."
    };
    //21->6
    private static String[] V_G = {
            "Siga pelo caminho em direção ao corredor do Bloco G.",
            "Vire à esquerda no corredor do Bloco G.",
            "Siga em direção à entrada do Bloco G."
    };
    private static String[] G_G4 = {"Siga pela calçada em direção ao Bloco G4"};
    private static String[] G4_G = {"Siga pela calçada em direção ao Bloco G."};
    private static String[] H_I = {
            "Siga em direção ao portão.",
            "Vire à direita em direção à faixa de pedestres.",
            "Atravesse a rua do Príncipe pela faixa de pedestres.",
            "Vire à direita em direção ao Bloco I."
    };
    private static String[] I_H = {
            "Siga pela calçada até a faixa de pedestres.",
            "Atravesse a rua pela faixa de pedestres",
            "Vire à direita em direção ao portão",
            "Vire à esquerda em direção à Capela"
    };
    private static String[] H_P = {"Siga em direção ao Estacionamento dos funcionários."};
    private static String[] P_H = {"Siga em direção à Capela."};
    private static String[] I_J = {
            "Siga no sentido contràrio da rua do Príncipe.",
            "Vire à esquerda em direção ao bloco I"
    };
    private static String[] J_I = {
            "Siga em direção à rua do Príncipe.",
            "Vire à direita em direção ao Bloco I."
    };
    private static String[] K_L = {
            "Siga pela rua Eduardo de Carvalho em direção à rua Afonso Pena.",
            "Vire à esquerda na rua Afonso Pena.",
            "Siga em direção ao Bloco L."
    };
    private static String[] L_K = {
            "Siga pela rua Afonso Pena em direção à rua Eduardo de Carvalho.",
            "Vire à esquerda na rua Eduardo de Carvalho.",
            "Siga em direção ao Bloco K."
    };
    private static String[] K_O = {
            "Siga em direção à rua Manoel Pereira.",
            "Vire à direita na rua Manoel Pereira.",
            "Vire à direita na rua Eduardo de Carvalho.",
            "Siga em direção ao Bloco K."
    };
    private static String[] O_K = {
            "Siga em direção à rua Manoel Pereira.",
            "Vire à esquerda na rua Manoel Pereira.",
            "Vire à esquerda na rua Almeida Cunha.",
            "Siga em direção ao Bloco O."
    };
    private static String[] K_W = {
            "Siga pela rua Eduardo de Carvalho em direção à rua Afonso Pena.",
            "Vire à direita em direção ao BLoco W."
    };
    private static String[] W_K = {
            "Atravesse a rua Eduardo de Carvalho.",
            "Vire à direita em direção ao Bloco K."
    };
    private static String[] L_N = {
            "Siga pela rua Afonso Pena em direção à rua Almeida Cunha.",
            "Vire à direita em direção ao Bloco N."
    };
    private static String[] N_L = {
            "Siga pela rua Almeida Cunha em direção à rua Afonso Pena.",
            "Vire à esquerda em direção ao Bloco L."
    };
    private static String[] L_W = {
            "Siga pela rua Afonso Pena em direção à rua Eduardo de Carvalho.",
            "Vire à esquerda na rua Eduardo de Carvalho.",
            "Vire à direita em direção ao Bloco W."
    };
    private static String[] W_L = {
            "Atravesse a rua Eduardo de Carvalho e vire à esquerda.",
            "Siga em direção a rua Afonso pena e vire à direita.",
            "Siga em direção ao Bloco L."
    };
    private static String[] M_V = {"Siga em direção ao Jardim"};
    private static String[] V_M = {"Siga em direção à Biblioteca"};
    private static String[] N_O = {"Siga em direção ao Bloco O."};
    private static String[] O_N = {"Siga em direção ao Bloco N."};

    private static String[] N_T = {
            "Siga pela rua Almeida em direção à rua Afonso Pena.",
            "Vire à direita na rua Afonso Pena.",
            "Siga em direção ao Bloco T"
    };
    private static String[] T_N = {
            "Siga pela rua Afonso Pena em direção à rua Almeida Cunha.",
            "Atravesse a rua Almeida Cunha.",
            "Vire à direita em direção ao Bloco N."
    };
    private static String[] P_U = {
            "Siga em direção ao final do Bloco A.",
            "Vire à direita em direção à calçada.",
            "Vire à direita em direção à Quadra de esportes"
    };
    private static String[] U_P = {
            "Siga pela calçada e vire à esquerda.",
            "Ande até passar do prédio do Bloco A.",
            "Vire à esquerda em direção ao Estacionamento dos funcionários"
    };
    private static String[] Q_U = {
            "Siga em direção à frente da Quadra de esportes.",
            "Vire à esquerda em direção à Quadra de esportes."
    };
    private static String[] U_Q = {
            "Siga pela lateral esquerda da Quadra de esportes.",
            "Vire à direita em direção ao Bloco.Q"
    };
    private static String[] R_T = {
            "Siga pelo corredor em direção à rua do lazer.",
            "Vire à direita na rua do lazer.",
            "Siga em direção à rua Afonso Pena.",
            "Vire à direita na rua Afonso Pena.",
            "Siga pela rua Afonso Pena.",
            "Vire à esquerda em direção ao Bloco T."
    };
    private static String[] T_R = {
            "Atravesse a rua Afonso Pena e vire à direita",
            "Siga pela rua Afonso Pena em direção à rua do lazer.",
            "Vire à esquerda na rua do lazer.",
            "Siga pela rua do lazer.",
            "Vire à esquerda em direção ao Bloco R."
    };
    private static String[] R_V = {
            "Siga pelo corredor em direção ao portão.",
            "Vire à esquerda no caminho em direção ao Jardim"
    };
    private static String[] V_R = {
            "Siga pelo caminho do Jardim em direção ao corredor.",
            "Vire à direita em direção ao Bloco R."
    };
    private static String[] S_T = {
            "Siga em direção à rua Afonso Pena.",
            "Vire à esquerda e atravesse a rua Almeida Cunha.",
            "Siga pela rua Afonso Pena.",
            "Vire à direita em direção ao Bloco T"
    };
    private static String[] T_S = {
            "Atravesse a rua Afonso Pena.",
            "Siga em direção à rua Almeira Cunha.",
            "Atravesse a rua Almeida Cunha.",
            "Vire à direita em direção ao Estacionamento dos estudantes."
    };

}