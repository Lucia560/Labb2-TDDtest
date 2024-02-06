package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
 @BeforeEach
  void setUp() {
        calculator = new Calculator();
    }
  @Test
  @DisplayName("Given an empty string return 0")
  void givenAnEmptyStringReturnZero() {
     assertEquals(0,calculator.Add(""));
  }
  @Test
  @DisplayName("Given unknown amount of numbers should return the correct sum ")
  void givenUnknownAmounOfNumbersShouldREturnTheCorrectSum() {

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

      String numbers = "4\n3,5";
      var result = calculator.Add(numbers);

      assertThat(result).isEqualTo(12);
  }

  @Test
  @DisplayName("Given more than one number use the format //  new delimiter \\ , Add return their sum")
    void givenMoreThanOneNumberUseTheNewFormatAndReturnTheirSum() {

        String numbers = "//;\n1;2";
        var result = calculator.Add(numbers);

        assertThat(result).isEqualTo(3);

    }

    @Test
    @DisplayName("Throw IllegalArgumentException for input with comma followed by newline")
    void throwIllegalArgumentExceptionForCommaFollowedByNewline() {
        String numbers = "1,\n";

        var exception = assertThrows(IllegalArgumentException.class, () -> calculator.Add(numbers));

        String expectedMessage = "Invalid format.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Given negative number throw an exception and show  all the negative numbers")
    void givenNegativeNumberThrowAnExceptionAndShowAllTheNegativeNumbers(){
       String numbers ="-3,3,6";

      var exception = assertThrows(IllegalArgumentException.class,()->calculator.Add(numbers));

      String expectedMessage = "Negative numbers are not allowed:-3";
      String actualMessage = exception.getMessage();

      assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    @DisplayName("Given numbers bigger than 1000 replace them with 0 ")
    void givenNumbersBiggerThan_1000ReplaceThemWith_0(){
       String numbers = "2,1000";
       var result = calculator.Add(numbers);

       assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("Given more than one number custom delimiter can have any length")
    void givenMoreThanOneNumberCustomDelimiterCanHaveAnyLength(){
      String numbers = "//[***]\n5***6";
      var result = calculator.Add(numbers);

      assertThat(result).isEqualTo(11);
    }

    @Test
    @DisplayName("Given more than one number allow multiple delimiters")
    void givenMoreThanOneNumberAllowMultipleDelimiters(){
      String numbers = "//[*][%]\n6*7%3";
      var result = calculator.Add(numbers);

      assertThat(result).isEqualTo(16);
    }

    @Test
    @DisplayName("Given more than one number allow multiple delimiters of any length")
    void allowMultipleDelimitersOfAnyLength() {
        String input = "//[***][%%%]\n1***2%%%3";
        int result = calculator.Add(input);

        assertThat(result).isEqualTo(6);
    }

}













