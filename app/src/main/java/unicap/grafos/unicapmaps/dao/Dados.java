package unicap.grafos.unicapmaps.dao;

/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
class Dados {


    private static int matrizAdjacencias[][] = { //matriz nova com arestas simples. precisa passar o procedimento de espelhamento
          // A B C D E F G H I J K L M N O P Q R S T U V W G4
            {0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,0}, //0  A
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //1  B
            {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //2  C
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //3  D
            {0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0}, //4  E
            {0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0}, //5  F
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,1,0,1}, //6  G
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, //7  H = Capela
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //8  I
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //9  J
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0}, //10 K
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0}, //11 L
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0}, //12 M = Biblioteca
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0}, //13 N
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //14 O
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0}, //15 P = Estacionamento professores
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0}, //16 Q
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0}, //17 R
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0}, //18 S = Estacionamento estudantes
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //19 T
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //20 U = Quadra de esportes
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //21 V = Jardim dos patos
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //22 W
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}  //23 G4
          // A B C D E F G H I J K L M N O P Q R S T U V W G4
    };



    public static int coordenadasVertices[][] = {
            { 587,810},  //0  A
            { 556,810},  //1  B
            { 433,735},  //2  C
            { 661,794},  //3  D
            { 733,508},  //4  E
            { 812,1214}, //5  F
            { 572,1118}, //6  G
            { 437,649},  //7  H = Capela
            { 850,442},  //8  I
            { 870,209},  //9  J
            {1091,1354}, //10 K
            { 863,1275}, //11 L
            { 451,989},  //12 M = Biblioteca
            { 993,1172}, //13 N
            {1086,1172}, //14 O
            { 516,707},  //15 P = Estacionamento professores
            { 752,664},  //16 Q
            { 659,1002}, //17 R
            { 579,1176}, //18 S = Estacionamento estudantes
            { 860,1044}, //19 T
            { 684,636},  //20 U = Quadra de esportes
            { 543,1002}, //21 V = Jardim dos patos
            {1016,1398}, //22 W
            { 343,1116}, //23 G4
    };

    private static int coordenadasComplementares[][][] = {
        {},                                                                               //id:0  (Bloco A -> Bloco B)
        {{619,794}},                                                                      //id:1  (Bloco A -> Bloco D)
        {{605,707}, {605,607},{664,607},{670,508}},                                       //id:2  (Bloco A -> Bloco E)
        {{587,877},{812,877},{812,1124}},                                                 //id:3  (Bloco A -> Bloco F)
        {{587,877},{812,877},{812,1124}},                                                 //id:4  (Bloco A -> Bloco G)
        {{587,877},{659,877}},                                                            //id:5  (Bloco A -> Bloco R)
        {{587,877},{812,877},{812,1044}},                                                 //id:6  (Bloco A -> Bloco T)
        {{605,707}, {605,607},{664,607}},                                                 //id:7  (Bloco A -> Quadra de esportes)
        {{587,877},{659,877},{659,963}, {584,963},{568,969},{557,980}},                   //id:8  (Bloco A -> Jardim)
        {{438,810}},                                                                      //id:9  (Bloco B -> Bloco C)
        {},                                                                               //id:10 (Bloco B -> Estacionamento professores)
        {},                                                                               //id:11 (Bloco C -> Capela)
        {},                                                                               //id:12 (Bloco C -> Estacionamento professores)
        {{812,508}},                                                                      //id:13 (Bloco E -> Bloco F)
        {{812,508},{812,1124}},                                                           //id:14 (Bloco E -> Bloco G)
        {{447,508}},                                                                      //id:15 (Bloco E -> Capela)
        {{447,508},{447,492},{483,492},{493,442}},                                        //id:16 (Bloco E -> Bloco I)
        {{812,508},{812,877},{658,877}},                                                  //id:17 (Bloco E -> Bloco R)
        {{812,508},{812,1044}},                                                           //id:18 (Bloco E -> Bloco T)
        {{670,508},{664,607}},                                                            //id:19 (Bloco E -> Quadra de esportes)
        {{863,1214}},                                                                     //id:20 (Bloco F -> Bloco L)
        {{863,1214},{863,1172}},                                                          //id:21 (Bloco F -> Bloco N)
        {{812,877},{659,877}},                                                            //id:22 (Bloco F -> Bloco R)
        {{812,1176}},                                                                     //id:23 (Bloco F -> Estacionamento estudantes)
        {{812,1044}},                                                                     //id:24 (Bloco F -> Bloco T)
        {{572,1086},{472,1086},{472,1066},{483,1047},{484,1021},{480,1005},{468,996}},    //id:25 (Bloco G -> Biblioteca)
        {{572,1086}, {663,1052}},                                                         //id:26 (Bloco G -> Bloco R)
        {},                                                                               //id:27 (Bloco G -> Estacionamento estudantes)
        {{812,1124},{812,1044}},                                                          //id:28 (Bloco G -> Bloco T)
        {{572,1086}, {522,1086},{522,1066},{543,1011}},                                   //id:29 (Bloco G -> Jardim)
        {},                                                                               //id:30 (Bloco G -> Bloco G4)
        {{447,508},{447,492},{483,492},{493,442}},                                        //id:31 (Capela -> Bloco I)
        {},                                                                               //id:32 (Capela -> Estacionamento professores)
        {{902,442},{884,271}},                                                            //id:33 (Bloco I -> Bloco J)
        {{863,1354}},                                                                     //id:34 (Bloco K -> Bloco L)
        {{1143,1354},{1135,1172}},                                                        //id:35 (Bloco K -> Bloco O)
        {{1016,1354}},                                                                    //id:36 (Bloco K -> Bloco W)
        {{863,1172}},                                                                     //id:37 (Bloco L -> Bloco N)
        {{863,1354},{1016,1354}},                                                         //id:38 (Bloco L -> Bloco W)
        {{466,989},{480,993},{486,992},{501,999},{522,1003}},                             //id:39 (Biblioteca -> Jardim)
        {},                                                                               //id:40 (Bloco N -> Bloco O)
        {{863,1172}},                                                                     //id:41 (Bloco N -> Bloco T)
        {{575,607},{664,607}},                                                            //id:42 (Estacionamento professores -> Quadra de esportes)
        {{721,636}},                                                                      //id:43 (Bloco Q -> Quadra de esportes)
        {{659,877},{812,877},{812,1044}},                                                 //id:44 (Bloco R -> Bloco T)
        {{659,963},{584,963},{568,969},{557,980}},                                        //id:45 (Bloco R -> Jardim)
        {{812,1176}, {812,1044}}                                                          //id:46 (Estacionamento estudantes -> Bloco T)
    };

    private static int[] custos = {
       11,     //id:0  (Bloco A -> Bloco B)
       30,     //id:1  (Bloco A -> Bloco D)
       124,    //id:2  (Bloco A -> Bloco E)
       380,    //id:3  (Bloco A -> Bloco F)
       270,    //id:4  (Bloco A -> Bloco G)
       92,     //id:5  (Bloco A -> Bloco R)
       190,    //id:6  (Bloco A -> Bloco T)
       94,     //id:7  (Bloco A -> Quadra de esportes)
       117,    //id:8  (Bloco A -> Jardim)
       68,     //id:9  (Bloco B -> Bloco C)
       34,     //id:10 (Bloco B -> Estacionamento professores)
       29,     //id:11 (Bloco C -> Capela)
       28,     //id:12 (Bloco C -> Estacionamento professores)
       256,    //id:13 (Bloco E -> Bloco F)
       316,    //id:14 (Bloco E -> Bloco G)
       126,    //id:15 (Bloco E -> Capela)
       192,    //id:16 (Bloco E -> Bloco I)
       250,    //id:17 (Bloco E -> Bloco R)
       225,    //id:18 (Bloco E -> Bloco T)
       64,     //id:19 (Bloco E -> Quadra de esportes)
       36,     //id:20 (Bloco F -> Bloco L)
       65,     //id:21 (Bloco F -> Bloco N)
       197,    //id:22 (Bloco F -> Bloco R)
       93,     //id:23 (Bloco F -> Estacionamento estudantes)
       47,     //id:24 (Bloco F -> Bloco T)
       72,     //id:25 (Bloco G -> Biblioteca)
       40,     //id:26 (Bloco G -> Bloco R)
       12,     //id:27 (Bloco G -> Estacionamento estudantes)
       104,    //id:28 (Bloco G -> Bloco T)
       60,     //id:29 (Bloco G -> Jardim)
       68,     //id:30 (Bloco G -> Bloco G4)
       128,    //id:31 (Capela -> Bloco I)
       35,     //id:32 (Capela -> Estacionamento professores)
       95,     //id:33 (Bloco I -> Bloco J)
       98,     //id:34 (Bloco K -> Bloco L)
       50,     //id:35 (Bloco K -> Bloco O)
       32,     //id:36 (Bloco K -> Bloco W)
       84,     //id:37 (Bloco L -> Bloco N)
       84,     //id:38 (Bloco L -> Bloco W)
       23,     //id:39 (Biblioteca -> Jardim)
       29,     //id:40 (Bloco N -> Bloco O)
       70,     //id:41 (Bloco N -> Bloco T)
       80,     //id:42 (Estacionamento professores -> Quadra de esportes)
       22,     //id:43 (Bloco Q -> Quadra de esportes)
       168,    //id:44 (Bloco R -> Bloco T)
       50,     //id:45 (Bloco R -> Jardim)
       115     //id:46 (Estacionamento estudantes -> Bloco T)
    };



    static int[][] getCoordenadasVertices() {
        return coordenadasVertices;
    }

    static int[][] getMatrizAdjacencias() {
        return matrizAdjacencias;
    }


    static int[][][] getCoordenadasComplementares() {
        return coordenadasComplementares;
    }

    static int[] getCustos() {
        return custos;
    }
}

