package org.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class First_Test {

	@Test
	void test() {
		 /**
   	  * создание экземпляра класса Credit_Calc
   	  */
   	 Credit_Calculator test = new Credit_Calculator();
   	 /**
   	  * вызов метода расчета кредита с введенными данными
   	  */
   	 test.calculate_anuity(10000, 12, 5, 1, 1);
   	 /**
   	  * присвоение переменной summa результатов вычисления общей суммы аннуитетных платежей по кредиту		
   	  */
   	 double summa = test.getSumm_anuity();
   	 /**
   	  * сравнение значения переменной summa с верным значением		         
   	  */
   	 assertEquals(summa, 10285.9);
	}

}
