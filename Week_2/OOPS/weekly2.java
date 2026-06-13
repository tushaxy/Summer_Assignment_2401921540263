package live;
interface Playable {
    void play();
}
class Veena implements Playable {
    @Override
    public void play() {
        System.out.println("Playing sweet tunes on the Veena");
    }
}
class Saxophone implements Playable {
    @Override
    public void play() {
        System.out.println("Playing smooth jazz on the Saxophone");
    }
}
public class Test {
    public static void main(String[] args) {
        Veena classicalInstrument = new Veena();
        classicalInstrument.play();
        Saxophone jazzInstrument = new Saxophone();
        jazzInstrument.play();
        
        System.out.println("------------------------------------");
        Playable dynamicInstrument;
        
        dynamicInstrument = classicalInstrument;
        dynamicInstrument.play();
        
        dynamicInstrument = jazzInstrument;
        dynamicInstrument.play();
    }
}
