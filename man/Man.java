import java.util.Random;
public class Man {
    // конструктор класса
    // (вызывается при создании нового экземпляра класса)
    private byte getRandom(int min, int max) {
        Random random = new Random();
        return (byte) (random.nextInt(max-min) +min);
    }
    public Man(String _name) {
        Name = _name;
        isLife = true;
        // неизменяемые переменные вне класса
        Age = getRandom(10,100);
        // генерация от 10 до 101
        Health = getRandom(10,101);
    }
    final String Name;
    final byte Age;
    final byte Health;
    private boolean isLife;
    public void Talk() {
        byte random_talk  = getRandom(1,4);
        String str = "";
        if (isLife)
            switch (random_talk) {
                case 1 -> str = "Приветствую, меня зовут " + Name;
                case 2 -> str = "Мне " + Age + " лет. А тебе сколько?";
                case 3 -> {
                    if (Health > 70)
                        str = "Мне ещё жить и жить, моему состоянию здоровья можно позавидовать)";
                    else
                        str = "Что-то не очень мне..";
                }
            }
        else
            str = Name + " я умер("; System.out.println(str);
    }
    public void Go() {
        String outString;
        if (isLife) {
            if (Health > 70) {
                outString = Name + " поехал(a) в парк развлечений";
                System.out.println(outString);
            } else {
                outString = Name + " поехал(а) в больницу, проверюсь";
                System.out.println(outString);
            }
        }
        else {
            outString = Name + " я умер(";
            System.out.println(outString);
        }
    }
    public boolean isAlive() {
        return isLife;
    }
    public void Kill() {
        isLife = false;
    }
}
