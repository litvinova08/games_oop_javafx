package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void move() throws Exception{
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void moveFalse() throws Exception{
        Logic logic = new Logic();
        BishopBlack bishopFirst = new BishopBlack(Cell.C1);
        BishopBlack bishopSecond = new BishopBlack(Cell.D2);
        logic.add(bishopFirst);
        logic.add(bishopSecond);
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(false));
    }
}