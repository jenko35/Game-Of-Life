package bbc.gameoflife;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   LifeTest.class,
   CellTest.class,
   NeigboursTest.class,
   GameOfLifeTest.class
})
public class JunitTestSuite {   
}  