package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

 Calculator calculator;
  // tests for empty string. one number , 2 numbers and unknown amount numbers

  @Test
  @DisplayName("Given an empty string return 0")
  void givenAnEmptyStringReturnZero() {
      var calculator =  new Calculator();
      var result = calculator.Add("");

      assertEquals(0, calculator.Add(""));
  }

  @Test
  @DisplayName("Given two as number return  sum as two")
  void givenTwoAsANumberReturnSumAsTwo(){
      var calculator =  new Calculator();
      assertEquals(2,calculator.Add("2"));
  }

  @Test
  @DisplayName("Given two and five as numbers return the sum equals  seven ")
  void givenTwoAndFiveAsNumbersTheSumEqualsSeven(){
      var calculator =  new Calculator();
      assertEquals(7,calculator.Add("2,5"));
  }

 /* @Test
  @DisplayName("Given more than two numbers should throwRuntimeException")
  void givenMoreThanTwoNumbersShouldThrowRuntimeException(){
      var calculator = new Calculator();
      assertThrows(RuntimeException.class,()->calculator.Add("2,5,7"));
  }*/

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


  }













