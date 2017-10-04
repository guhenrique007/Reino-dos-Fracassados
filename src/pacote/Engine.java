package pacote;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import pacote.Tela;
import pacote.Inicial;


public class Engine {
    
    public static String pal,pal2,c,word,d,e,f,g,h,i,j,k,l;
    public static int opcao=0;
    public static Book book;
    public static Player pablo;
    public static Enemy evil,boss;
    public static String choice0,choice10,choice11;
    public static String choice1,choice2,choice3,choice4,choice5,choice6,choice7,choice8,choice9;
    public static String ligadorS,eventoFinal0S,eventoMeioS;
    public static Item banana = new Item();
    
    public static void main(String[] args) throws IOException {
       book = Engine.createBook();
       pablo = new Player(100,10);
       evil = new Enemy(20,20);
       boss = new Enemy(100,20);
       Inicial.main(args);
       
        System.out.println(book.showHistoryBook());
        pal = book.showHistoryBook();
        

        Scanner in = new Scanner(System.in);

        do {
            System.out.println(book.showHistory());

            System.out.println("Escolha:  ");
            pal2 = book.showHistory();
            

            for(Choice choice:book.nextEvents()) {
                System.out.println(choice.getDescription());
                    if(pablo.isAlive() == false){
                        book.isTheEnd();
                    }
               
                
            }

            int i;
            do {
                i = in.nextInt();
            } while(!book.nextEvent(i));
        } while(!book.isTheEnd());

        System.out.println(book.showHistory());
    }

    public static Book createBook() {
        
        
        
        Event eventoFinal = new BlankEvent("Você morreu de fome.",new ArrayList<Choice>());
        c = eventoFinal.history();
        Event eventoFinal0 =  new BlankEvent("Ficou na floresta e morreu de fome.(POBRE PABLO!)",new ArrayList<Choice>());
        eventoFinal0S = eventoFinal0.history();
        Event eventoMeio = new BlankEvent("Você venceu o chefe,Pablo saiu do loop temporal",new ArrayList<Choice>());
        eventoMeioS = eventoMeio.history();
        Event eventoMorte  = new BlankEvent("Pablo está morto.",new ArrayList<>()); 
        f = eventoMorte.history();
        
        Event eventoterra = new BlankEvent("",new ArrayList<Choice>());
        
        Collection escolhaDestino = new ArrayList<Choice>();
        Choice continuar = new BlankChoice("Continuar o loop(Ganhe + 20 atq)",eventoterra);
        Engine.choice10 = continuar.getDescription();
        Choice sair = new BlankChoice("Sair do jogo",eventoterra);
        Engine.choice11 = sair.getDescription();
        escolhaDestino.add(continuar);
        escolhaDestino.add(sair);
        
        
        
        Event eventPrefim = new BlankEvent("Pablo foge sem levar dano.",new ArrayList<Choice>());
        j = eventPrefim.history();
        
        Collection escolhaBoss = new ArrayList<BattleChoice>();
        BattleChoice lutar = new BattleChoice("Lutar",eventoMeio,boss);
        Engine.choice8 = lutar.getDescription();
        Choice fugir = new BlankChoice("Fugir",eventPrefim);
        Engine.choice9 =  fugir.getDescription();
        escolhaBoss.add(lutar);
        escolhaBoss.add(fugir);
        
        Event eventContinua = new BlankEvent("Pablo encontrou o PABLO REVERSO.",escolhaBoss);
        h = eventContinua.history();
        
        Collection escolhaRoubar = new ArrayList<Choice>();
        Choice rouba = new BlankChoice("Roubar uma banana",eventContinua);
        Engine.choice6 = rouba.getDescription();
        Choice nada = new BlankChoice("Não roubar",eventContinua);
        Engine.choice7 = nada.getDescription();
        escolhaRoubar.add(rouba);
        escolhaRoubar.add(nada);
        
        
        
        Event eventoBattle = new BlankEvent("Você venceu a luta e acha banana no malandro.",escolhaRoubar);
        d = eventoBattle.history();
    
        Collection escolhasTridimensionais = new ArrayList<BattleChoice>();
        Event eventoFuga   = new BlankEvent("Malandro é rápido,Pablo apanhou pelas costas.",escolhasTridimensionais);
        e = eventoFuga.history();
        BattleChoice escolhaLutar = new BattleChoice("Lutar",eventoBattle,new Enemy(10,1));
        Engine.choice4 = escolhaLutar.getDescription();
        Choice escolhaFugir = new BlankChoice("Fugir",eventoFuga);
        Engine.choice5 = escolhaFugir.getDescription();
        escolhasTridimensionais.add(escolhaLutar);
        escolhasTridimensionais.add(escolhaFugir);
        

        
        Event ligador2 = new BlankEvent("Você encontrou um Malandro.",escolhasTridimensionais);
        g = ligador2.description;
        
        Collection escolhasMeio = new ArrayList<Choice>();
        Choice escolhaCome = new BlankChoice("Comer",ligador2);
        Engine.choice2 = escolhaCome.getDescription();
        Choice escolhaGuardar =  new BlankChoice("Guardar",eventoFinal);
        Engine.choice3 = escolhaGuardar.getDescription();
        escolhasMeio.add(escolhaCome);
        escolhasMeio.add(escolhaGuardar);
        
        Event ligador = new BlankEvent("No caminho da trilha,Pablo achou 1 banana.",escolhasMeio);
        ligadorS = ligador.description; 
        
        Collection escolhasIniciais = new ArrayList<Choice>();
        Choice escolhaFinalTrilha = new BlankChoice("Fica na floresta", eventoFinal0);
        Engine.choice0 = escolhaFinalTrilha.getDescription();
        Choice escolhaFinalFloresta = new BlankChoice("Segue a trilha", ligador);
        Engine.choice1 = escolhaFinalFloresta.getDescription();
        escolhasIniciais.add(escolhaFinalTrilha);
        escolhasIniciais.add(escolhaFinalFloresta);

        Event eventoInitial = new BlankEvent("Pablo se perdeu na floresta e avista uma trilha.", escolhasIniciais);
        

        Book livro = new Book("A história de Pablo", eventoInitial, new Player(10, 10));

        return livro;
    }     
}
