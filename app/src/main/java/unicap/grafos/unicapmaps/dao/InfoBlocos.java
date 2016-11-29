package unicap.grafos.unicapmaps.dao;
import java.util.ArrayList;

/**
 * Created by uira on 12/11/16.
 */

public class InfoBlocos {
    private ArrayList<String[]> infoBlocos;

    public InfoBlocos(){
        infoBlocos = new ArrayList();
        infoBlocos.add(A);      //0  A
        infoBlocos.add(B);      //1  B
        infoBlocos.add(C);      //2  C
        infoBlocos.add(D);      //3  D
        infoBlocos.add(E);      //4  E
        infoBlocos.add(F);      //5  F
        infoBlocos.add(G);      //6  G
        infoBlocos.add(H);      //7  H = Capela
        infoBlocos.add(I);      //8  I
        infoBlocos.add(J);      //9  J
        infoBlocos.add(K);      //10 K
        infoBlocos.add(L);      //11 L
        infoBlocos.add(M);      //12 M = Biblioteca
        infoBlocos.add(N);      //13 N
        infoBlocos.add(O);      //14 O
        infoBlocos.add(P);      //15 P = Estacionamento funcionários
        infoBlocos.add(Q);      //16 Q
        infoBlocos.add(R);      //17 R
        infoBlocos.add(S);      //18 S = Estacionamento estudantes
        infoBlocos.add(T);      //19 T
        infoBlocos.add(U);      //20 U = Quadra de esportes
        infoBlocos.add(V);      //21 V = Jardim
        infoBlocos.add(W);      //22 W
        infoBlocos.add(G4);     //23 G4
    }

    private static String[] nomesBlocos = {
            "Bloco A",
            "Bloco B",
            "Bloco C",
            "Bloco D",
            "Bloco E",
            "Bloco F",
            "Bloco G",
            "Capela",
            "Bloco I",
            "Bloco J",
            "Bloco K",
            "Bloco L",
            "Biblioteca",
            "Bloco N",
            "Bloco O",
            "Estacionamento funcionários",
            "Bloco Q",
            "Bloco R",
            "Estacionamento estudantes",
            "Bloco T",
            "Quadra de esportes",
            "Jardim",
            "Bloco W",
            "Bloco G4"
    };

    public static String[] getNomesBlocos(){
        return nomesBlocos;
    }

    public ArrayList<String[]> getInfoBlocos(){
        return infoBlocos;
    }

    private String[] A = {
        "Portaria",
        "Posto de uma agência do banco Santander (2 caixas eletrônicos)",
        "SBS - Livraria Internacional",
        "FASA - Fundação Antônio dos Santos Abranches",
        "Sala 104 - Laboratório de Cinesiologia e Método e Técnicas de Avaliação",
        "Sala 105 - Laboratório de Recursos Terapêuticos e Prótese e Ortése ",
        "Sala 107 - Laboratório de Filosofia e Imagenologia ",
        "Sala 108 - Laboratório de Cinesioterapia ",
        "Sala 109 - Laboratório de Manipulação ",
        "Sala 110 - Laboratório de Eletrofototermoterapia ",
        "Sala 204 - Laboratório de Ciências ",
        "Salas 205/206 - Laboratório de Zoologia",
        "Sala 207 - Laboratório de Botânica ",
        "Salas 208/209 - Secretaria de Apoio aos Laboratórios de Biologia e Fisioterapia ",
        "Sala 210 - Laboratório de Citologia, Histologia e Embriologia ",
        "Salas 211/212 - Laboratório de Anatomia ",
        "Sala 404 - Laboratório de Comunicação Visual",
        "Sala 405 - Laboratório de Jogos Digitais",
        "Sala 407 - Laboratório Multiuso: Publicidade e Cursos de Tecnologia ",
        "Sala 408 - Hemeroteca ",
        "Sala 409 - Secretaria, Coordenação, Assessoria e Sala dos Professores do CCS - Centro de Comunicação Social (Jornalismo, Relações Públicas, Jogos Digitais e Publicidade e Propaganda). ",
        "Sala 410 - Arquivo ",
        "Sala 411 - AGERP - Agência Experimental de Relações Públicas ",
        "Sala 504 - Estúdio de Telejornalismo ",
        "Sala 505 - Estúdio de Radiojornalismo ",
        "Sala 506 - Laboratório de Redação Jornalística (TV) ",
        "Sala 507 - Laboratório de Redação Jornalística (Rádio) ",
        "Sala 809 - Escritório Modelo - Arquitetura e Urbanismo "
    };

    private String[] B = {
        "PROCOM - Pró-Reitoria Comunitária",
        "Sala 002 - Coordenação de Ação Comunitária",
        "Sala 003 - Secretaria",
        "Sala 004 - Espaço Loyola",
        "Salas 005/006/007 - Divisão de Ação Social",
        "Sala 008 - Instituto Humanitas Unicap",
        "Sala 102 - Auditório Inácio de Azevedo",
        "Sala 103 - Assessoria C.T.C.H.",
        "Salas 104/105 - Secretaria C.T.C.H.",
        "Sala 106 - Coordenação do curso de Pedagogia / Coordenação de Estágio",
        "Sala 107 - Coordenação do curso de História / Coordenação do curso de Letras",
        "Sala 108 - Coordenação do curso de Filosofia / Coordenação do curso de Teologia",
        "Sala 109 - Sala dos Professores",
        "Sala 110 - Espaço Cultural",
        "Sala 206 - Arquivo C.T.C.H.",
        "6º andar - Clínica de Fonoaudiologia",
        "7º andar - C.C.B.S. - Centro de Ciências Biológicas e Sáude",
        "Sala 713 - Secretaria C.C.B.S.",
        "Sala 715 - Coordenação Fisioterapia / Coordenação Ciências Biológicas",
        "Sala 716 - Sala de Ludoterapia",
        "Sala 717 - Coordenação Psicologia / Coordenação Terapia Ocupacional",
        "Sala 719 - Pastoral",
        "Sala 721 - Centro de Estudos sobre Parkinson",
        "Sala 728 - Atendimento Otorrino",
        "8º andar - Clínica de Psicologia"
    };

    private String[] C = {
        "Cabine da Telefonista",
        "Ouvidoria Comunitária",
        "CETEC - Centro de Educação Técnico e Cultural",
        "DMP - Divisão de Manutenção Predial",
        "Oficina Elétrica",
    };

    private String[] D = {
        "Escritório Técnico e Patrimônio",
        "Sala 002 - Secretaria CCT",
        "Sala 003 - Laboratório de CAD",
        "Sala 004 - Laboratório de Estruturas",
        "Sala 005 - Laboratório de Tecnologia de Materias",
        "Sala 008 - Laboratório de Mecância dos Fluidos e Hidráulica",
        "Sala 009 - Laboratório de Computação",
        "Sala 010 - Laboratório de Geotecnia",
        "Sala 011 - Câmara Úmida",
        "Sala 012 - Laboratório de Conforto Ambiental",
        "Sala 014 - Oficina de Áudio/Vídeo",
        "Sala 102 - Coordenação do CCT",
        "Sala 107 - Laboratório de Arquitetura",
        "sala 110 - Laboratório de Geotecnia",
        "Sala 111 - Laboratório de Topografia",
        "Sala 112 - Laboratório de Geologia",
        "Sala 113 - Sala Multiuso do CCT",
        "Salas 202/206 - Laboratório de Arquitetura",
        "Salas 302/306 - Laboratório de Arquitetura",
        "Sala 402 - Laboratório de Física I e II",
        "Sala 406 - Laboratório de Arquitetura",
        "Sala 504 - Almoxarifado do Departamento de Física",
        "Salas 505/506 - Laboratório de Física III e IV",
        "Sala 602 - Laboratório de Química Orgânica e Polímeros",
        "Sala 604 - Laboratório de Físico-Química",
        "Sala 702 - Laboratório de Química Geral e Inorgânica I",
        "Sala 703 - GDEP - Grupo de Desenvolvimento de Equipamentos e Processos",
        "Sala 704 - Laboratório de Bioengenharia",
        "Sala 705 - Laboratório de Química Geral e Inorgânica II",
        "Sala 802 - Laboratório de Análises Químicas",
        "Sala 803 - Laboratório de Instrumentação",
        "Sala 804 - Laboratório de Química Analítica e Ambiental",
        "Sala 805 - Laboratório de Controle de Processos",
        "Sala 806 - Laboratório de Engenharia Química"
    };

    private String[] E = {
        "FASA Gráfica",
        "COAVE - Comissão para Aplicação do Vestibular"
    };

    private String[] F = {"Oficinas"};

    private String[] G = {
            "Sala 001 - Laboratório de Tratamento de Imagens do curso de Fotografia",
            "Sala 002 - Laboratório de Fotografia",
            "Sala 004 - Tesouraria",
            "Banco Itaú",
            "COGEST - Coordenação Geral de Estágio",
            "Sala 101 - Auditório G1",
            "Sala 102 - Auditório",
            "Sala 103/104 - Laboratórios Espaço Loyola",
            "Sala 105 - Auditório G2",
            "Sala 202 - Sala de Pesquisa Arqueológica",
            "Sala 203 - Laboratório e Museu de Arqueologia - LABMUSARq",
            "Salas 502/503 - Secretaria e Coordenação do CCB - Centro de Ciências Sociais (Gestão de Turismo, Gestão de Eventos, Gestão Portuária, Fotografia, Economia, Administração, Serviço Social e Contábeis)",
            "Sala 802 - Sala dos Professores do 1º Ciclo",
            "Sala 803 - Secretaria e Coordenação Geral do 1º Ciclo"
    };

    private String[] H = {
            "Atendimento Pastoral",
            "Serviço Médico",
            "Centro Cultural",
            "Almoxarifado / DIMAT - Divisão de Materiais"
    };

    private String[] I = {
            "Coordenação de Tecnologia de Informação",
            "Administração"
    };

    private String[] J = {
            "Medicina",
            "NPCIAMB"
    };

    private String[] K = {"DCE"};

    private String[] L = {"Astepi"};

    private String[] M = {};

    private String[] N = {"Unicap Jr."};

    private String[] O = {"Forum"};

    private String[] P = {};

    private String[] Q = {
            "Serventes",
            "Quadra A"
    };

    private String[] R = {
        "Salas 005, 009 - SERDAE (Setor de Processamento de Dados)",
        "Sala 011 - SERD (Setor de Emissão e Registro de Diplomas)",
        "Sala 012 - SEAD (Setor de Admissão)",
        "Sala 017 - SEPED (Setor de Protocolo)",
        "Sala 020 - DGE (Diretoria de Gestão Escolar)",
        "Sala 022 - SEAC (Arquivo Central do DGE)",
        "Atendimento para os setores de Admissão, Protocolo e Diplomas",
        "Sala 105 - Prad (Pró-Reitoria Administrativa)",
        "Salas 110, 111 - DPA (Divisão de Programação Acadêmica)",
        "Salas 112, 113, 114, 115, 116 - DIPES (Divisão de Pessoal)",
        "Sala 117 - ASSECOM e Aê (Assessoria de Comunicação e Agência Experimental de Publicidade e Propaganda)",
        "Salas 118, 118 - Contadoria",
        "Salas 120, 121 - DIFIC (Divisão de Finanças)",
        "Salas 204, 205 - Reitoria",
        "Salas 206, 207 - Sala dos Conselhos",
        "Sala 209 - Salão Nobre",
        "Sala 212 - Relações Interinstitucionais e Internacionais",
        "Salas 213, 214, 215, 216 - ASSEPLAN e Avaliação",
        "Anexo - ASSEJUR"
    };

    private String[] S = {};

    private String[] T = {
            "SEAR/SEPAT (escritório tecnico/patrimônio)"
    };

    private String[] U = {};

    private String[] V = {};

    private String[] W = {
            "Clínica Corpore Sano (Lab. de Fisioterapia e Terapia Ocupacional)"
    };

    private String[] G4 = {
            "Sala 001 - Laboratório de Áudio e Vídeo do curso de Publicidade, que é ligado ao CCS",
            "Sala 003 - Coordenação Geral de Pós-Graduação e Secretaria Acadêmica dos Mestrados e Doutorado",
            "Sala 005 - Sala de Teleconferências",
            "Secretaria Acadêmica da Especialização Latu sensu",
            "Secretaria Acadêmica da Especialização MBA",
            "Coordenação Geral de Extensão",
            "Anfiteatro",
            "Laboratório Religião, Cultura e Sociedade (Mestrado)",
            "Laboratório de Linguagem, Distúrbio e Multidisciplinaridade (Mestrado)",
            "Laboratório de Linguagem, Educação e Organização Sócio-Cultural (Mestrado)",
            "Centro de Convivência de Afásicos - Grupo de Estudos em Afasia e Gagueira",
            "Secretaria e Sala de Computação dos Mestrados",
            "Gabinete da Pró-Reitoria Acadêmica",
            "Coordenação Geral de Pesquisa",
            "Projeto de Iniciação científica (PIBIC)",
            "Comitê de Ética em Pesquisa",
            "Coordenação Geral de Graduação",
            "NAD - Núcleo de Atendimento ao Discente",
            "Gabinete da Coordenação Geral de Pós-Graduação",
            "Secretaria Administrativa dos cursos de Mestrado e Doutorado",
            "Gabinete dos coordenadores dos cursos de mestrado e doutorado",
            "Comissão Editorial"
    };
}
