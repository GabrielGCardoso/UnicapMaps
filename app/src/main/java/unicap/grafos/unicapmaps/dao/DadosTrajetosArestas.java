package unicap.grafos.unicapmaps.dao;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Trajeto;

/**
 * Created by uira on 12/11/16.
 */

public class DadosTrajetosArestas{

    private static ArrayList<Trajeto> trajetos;

    public DadosTrajetosArestas(){

    }

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

    private static String[] A_B = {};
    private static String[] B_A = {};
    private static String[] A_D = {};
    private static String[] D_A = {};
    private static String[] A_E = {};
    private static String[] E_A = {};
    private static String[] A_F = {};
    private static String[] F_A = {};
    private static String[] A_G = {};
    private static String[] G_A = {};
    private static String[] A_R = {};
    private static String[] R_A = {};
    private static String[] A_T = {};
    private static String[] T_A = {};
    private static String[] A_U = {};
    private static String[] U_A = {};
    private static String[] A_V = {};
    private static String[] V_A = {};
    private static String[] B_C = {};
    private static String[] C_B = {};
    private static String[] B_P = {};
    private static String[] P_B = {};
    private static String[] C_H = {};
    private static String[] H_C = {};
    private static String[] C_P = {};
    private static String[] P_C = {};
    private static String[] E_F = {};
    private static String[] F_E = {};
    private static String[] E_G = {};
    private static String[] G_E = {};
    private static String[] E_H = {};
    private static String[] H_E = {};
    private static String[] E_I = {};
    private static String[] I_E = {};
    private static String[] E_R = {};
    private static String[] R_E = {};
    private static String[] E_T = {};
    private static String[] T_E = {};
    private static String[] E_U = {};
    private static String[] U_E = {};
    private static String[] F_L = {};
    private static String[] L_F = {};
    private static String[] F_N = {};
    private static String[] N_F = {};
    private static String[] F_R = {};
    private static String[] R_F = {};
    private static String[] F_S = {};
    private static String[] S_F = {};
    private static String[] F_T = {};
    private static String[] T_F = {};
    private static String[] G_M = {};
    private static String[] M_G = {};
    private static String[] G_R = {};
    private static String[] R_G = {};
    private static String[] G_S = {};
    private static String[] S_G = {};
    private static String[] G_T = {};
    private static String[] T_G = {};
    private static String[] G_V = {};
    private static String[] V_G = {};
    private static String[] G_G4 = {};
    private static String[] G4_G = {};
    private static String[] H_I = {};
    private static String[] I_H = {};
    private static String[] H_P = {};
    private static String[] P_H = {};
    private static String[] I_J = {};
    private static String[] J_I = {};
    private static String[] K_L = {};
    private static String[] L_K = {};
    private static String[] K_O = {};
    private static String[] O_K = {};
    private static String[] K_W = {};
    private static String[] W_K = {};
    private static String[] L_N = {};
    private static String[] N_L = {};
    private static String[] L_W = {};
    private static String[] W_L = {};
    private static String[] M_V = {};
    private static String[] V_M = {};
    private static String[] N_O = {};
    private static String[] O_N = {};
    private static String[] N_T = {};
    private static String[] T_N = {};
    private static String[] P_U = {};
    private static String[] U_P = {};
    private static String[] Q_U = {};
    private static String[] U_Q = {};
    private static String[] R_T = {};
    private static String[] T_R = {};
    private static String[] R_V = {};
    private static String[] V_R = {};
    private static String[] S_T = {};
    private static String[] T_S = {};
}
