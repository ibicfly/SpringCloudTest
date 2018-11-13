package io.ibicfly.service0.designpattern;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/30 10:51
 * @Description: 作用描述
 * 工厂模式
 */
public class FactoryTest {

    public static void main(String[] args) {
        GameFactory gameFactory = null;
        gameFactory=new GameFactory() {
            @Override
            public Game getGame() {
                return new Chess();
            }
        };
        gameFactory.getGame().move();
        gameFactory=new GameFactory() {
            @Override
            public Game getGame() {
                return new Checkers();
            }
        };
        gameFactory.getGame().move();
    }
}
interface  Game{
    boolean move();
}
interface GameFactory{
    Game getGame();
}

class  Chess implements Game{
    @Override
    public boolean move() {
        System.out.println("Chess Move");
        return false;
    }
}
class  Checkers implements Game{
    @Override
    public boolean move() {
        System.out.println("Checkers Move");
        return false;
    }
}
class  ChessFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Chess();
    }
}
class  CheckersFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Checkers();
    }
}