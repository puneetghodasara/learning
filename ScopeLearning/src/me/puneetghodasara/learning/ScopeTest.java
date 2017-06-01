package me.puneetghodasara.learning;

/*
 * 
 * Summary:
 * Static Inner Class can not access field variable of outer class
 * Inner Class can not have static field variable of own
 * Classes/Interfaces can be anywhere
 * 
 * */

/**
 * There can be other classes inside same Java file
 * 
 */
class OuterClass {

	Integer outer;

	static Integer staticOuter;

	/**
	 * A static nested class <br>
	 * 1) can have all types of variables <br>
	 * 2) It CAN NOT access non static class of container class (Outer class)
	 *
	 */
	static class StaticInnerClass {
		static Integer a;
		static final Integer b = 3;

		Integer c;

		public StaticInnerClass() {
			// Not allowed
			// System.out.println(outer);
			System.out.println(staticOuter);
		}

	}

	/**
	 * A static nested class <br>
	 * 1) It CAN NOT have static variables <br>
	 * 2) It can access all types of variable from container class (Outer class)
	 *
	 */
	class InnerClass {

		// Not allowed
		// static Integer a = 3;

		final Integer b = 3;

		public InnerClass() {
			System.out.println(outer);
			System.out.println(staticOuter);
		}
	}
}

/**
 * A Java file can contain many classes
 *
 */
class AnotherClass {

	OuterClass outerClass = new OuterClass();

	// A way of instantiate Static Inner class.
	OuterClass.StaticInnerClass ocStaticInnerClass = new OuterClass.StaticInnerClass();

	// Two ways of instantiate inner classes. It requires object of outer class
	OuterClass.InnerClass ocInnerClass = outerClass.new InnerClass();
	OuterClass.InnerClass ocInnerClass1 = new OuterClass().new InnerClass();

	void myMethod() {

		/**
		 * A method can have class having method scoped class
		 *
		 */
		class LocalClass {

			void myLocalClass(Integer var) {
			}
		}

		LocalClass a = new LocalClass();
		LocalClass b = new LocalClass();

	}

	// Not allowed
	// LocalClass a = new LocalClass();

}

/**
 * Only name of public class should match with Java filename
 * 
 *
 */
public class ScopeTest {

}
