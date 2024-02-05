package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

 @Test
  @DisplayName("Given an empty string return 0")
  void givenAnEmptyStringReturnZero() {
      var calculator = new Calculator();

      assertEquals(0,calculator.Add(""));
  }
  @Test
  @DisplayName("Given unknown amount of numbers should return the correct sum ")
  void givenUnknownAmounOfNumbersShouldREturnTheCorrectSum() {
      var calculator = new Calculator();
      String numbers1 = "2,4,5,6";
      String numbers2 = "4,6,7,2,2,8,9";

      var result = calculator.Add(numbers1);
      var result1 = calculator.Add(numbers2);

      assertThat(result).isEqualTo(17);
      assertThat(result1).isEqualTo(38);
  }

  @Test
  @DisplayName("Given more than one number separate them by new line or comma and return their sum")
  void givenMoreThanANumberSeparateThemByNewLine(){
      var calculator =  new Calculator();
      String numbers = "4\n3,5";
      var result = calculator.Add(numbers);

      assertThat(result).isEqualTo(12);
  }

  @Test
  @DisplayName("Given more than one number use the format //  new delimiter \\ , Add return their sum")
    void givenMoreThanOneNumberUseTheNewFormatAndReturnTheirSum() {
        var calculator = new Calculator();
        String numbers = "//;\n1;2";
        var result = calculator.Add(numbers);

        assertThat(result).isEqualTo(3);

    }

    @Test
    @DisplayName("Throw IllegalArgumentException for input with comma followed by newline")
    void throwIllegalArgumentExceptionForCommaFollowedByNewline() {
        var calculator = new Calculator();
        String numbers = "1,\n";

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.Add(numbers);
        });

        String expectedMessage = "Invalid format.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Given negative number throw an exception and show  all the negative numbers")
    void givenNegativeNumberThrowAnExceptionAndShowAllTheNegativeNumbers(){
      var calculator = new Calculator();
      String numbers ="-3,3,6";

      var exception = assertThrows(IllegalArgumentException.class,()->calculator.Add(numbers));

      String expectedMessage = "Negative numbers are not allowed:-3";
      String actualMessage = exception.getMessage();

      assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    @DisplayName("Given numbers bigger than 1000 replace them with 0 ")
    void givenNumbersBiggerThan_1000ReplaceThemWith_0(){
       var calculator = new Calculator();
       String numbers = "2,1000";
       var result = calculator.Add(numbers);

       assertThat(result).isEqualTo(2);
    }

}













