package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

 Calculator calculator;
  // test for empty string. one number , 2 numbers

  @Test
  @DisplayName("Given an empty string return 0")
  void givenAnEmptyStringReturnZero() {
      var calculator =  new Calculator();
      var result = calculator.Add("");

      assertEquals(0, calculator.Add(""));
  }








  }













