package model.card.type;

import java.util.Arrays;

/**
 * Symbols (Numeric and special) for UNO Cards.
 * @author eriveros
 *
 */
public enum Symbol {
  ZERO("0"),
  ONE("1"),
  TWO("2"), 
  THREE("3"),
  FOUR ("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  SKIP("Saltar"),
  INVERT("Invertir Dirección"),
  DRAW_TWO("Robar 2"),
  WILD("Comodín"),
  WILD_DRAW_FOUR("Comodín + Roba 4");
  
  private String name;
  
  /**
   * Constructor for a symbol can assign a name for it.
   * @param name
   */
  Symbol(String name) {
    this.name = name;
  }
  
  /**
   * Returns the name of the symbol.
   * @return symbol's name
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Returns all of the symbols
   * @return all of the symbols.
   */
  public static Symbol[] getSymbols() {
    return Arrays.copyOfRange(Symbol.values(),0,15);
  }
}
