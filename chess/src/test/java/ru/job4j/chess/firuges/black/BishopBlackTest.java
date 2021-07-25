package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPositionF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell position = bishopBlack.position();
        assertThat(position, is(Cell.F8));
    }

    @Test
    public void testPositionC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell position = bishopBlack.position();
        assertThat(position, is(Cell.C8));
    }

    @Test
    public void testWayC1G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] wayC1G5bishop = bishopBlack.way(Cell.G5);
        Cell[] wayC1G5 = new Cell[4];
        wayC1G5[0] = Cell.D2;
        wayC1G5[1] = Cell.E3;
        wayC1G5[2] = Cell.F4;
        wayC1G5[3] = Cell.G5;
        assertThat(wayC1G5bishop, is(wayC1G5));
    }

    @Test
    public void testWayF8A3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] wayF8A3bishop = bishopBlack.way(Cell.A3);
        Cell[] wayF8A3 = new Cell[5];
        wayF8A3[0] = Cell.E7;
        wayF8A3[1] = Cell.D6;
        wayF8A3[2] = Cell.C5;
        wayF8A3[3] = Cell.B4;
        wayF8A3[4] = Cell.A3;
        assertThat(wayF8A3bishop, is(wayF8A3));
    }

    @Test
    public void testIsDiagonalC1G5() {
        assertTrue(BishopBlack.isDiagonal(Cell.C1, Cell.G5));
    }

    @Test
    public void testIsDiagonalF8A3() {
        assertTrue(BishopBlack.isDiagonal(Cell.F8, Cell.A3));
    }

    @Test
    public void testIsDiagonalF8B3() {
        assertFalse(BishopBlack.isDiagonal(Cell.F8, Cell.B3));
    }

    @Test
    public void testCopyF8A3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.A3);
        assertThat(bishopBlackCopy.position(), is(Cell.A3));
    }

    @Test
    public void testCopyC8H3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.H3);
        assertThat(bishopBlackCopy.position(), is(Cell.H3));
    }
}