<style>
body {
  font-family: "Gentium Basic", Cardo, "Linux Libertine o", "Palatino Linotype", Cambria, serif;
  font-size: 130% !important;
}
code {
	padding: 0 .25em;
	
	white-space: pre;
	font-family: "Tlwg mono", Consolas, "Liberation Mono", Menlo, Courier, monospace;
	
	background-color: #ECFFFA;
	//border: 1px solid #ccc;
	//border-radius: 3px;
}

kbd {
	display: inline-block;
	padding: 3px 5px;
	font-family: "Tlwg mono", Consolas, "Liberation Mono", Menlo, Courier, monospace;
	line-height: 10px;
	color: #555;
	vertical-align: middle;
	background-color: #ECFFFA;
	border: solid 1px #ccc;
	border-bottom-color: #bbb;
	border-radius: 3px;
	box-shadow: inset 0 -1px 0 #bbb;
}

h1,h2,h3,h4,h5 {
  color: #269B7D; 
  font-family: "fira sans", "Latin Modern Sans", Calibri, "Trebuchet MS", sans-serif;
}

img {
  width: auto; 
  height: 80%;
  max-height: 100%; 
}
</style>

# 2 Using functions in Java

## §2.1 What is a function

### §2.1.1 Functions in the real world
- a relation between a source set, called the _function domain_, to a target set, called the _function codomain_.
- all elements in the domain must have exactly one corresponding element in the codomain.

#### Implications
- _All_ elements in the domain must have a _singel_ corresponding value in the codomain
- _Not more than one_ element in the codomain can correspond _to the same element_ in the domain
- There may be elements in the codomain without a corresponding element in the domain
- There may be elements in the codomain with more than one corresponding element in the domain. (Such a function doesn't
  have a reverse function, though).
- The set of elements of the codomain that have a corresponding element in the
  domain is called the _image_ of the function.

$$
f(x) = 2 * x ⇔ f^{-1}(x) = x / 2 
$$
If f is a function from ℕ to ℕ then its inverse is not a function as the odd numbers of ℕ devided by 2 are not a member
of ℕ.

#### partial functions
- A relation that isn’t defined for all elements of the domain but that fulfills the rest of the requirement.
- many bugs are the result of using a partial function as if it were a total one.

$f(x) = 1 / x $ is a partial function from ℕ to ℚ, as it isn't defined for $x = 0$.
It is, however, a total function of $ℕ^+$ to ℕ.
- By adding an element to the codomain (the error condition), you can transform the partial function into a total one. 
  But to do this, the function needs a way to return an error.
- Turning partial functions into total ones is an important part of functional programming.

#### function composition
- $f ∘ g(x)$ pronounced f round g (in Dutch: f na g) is equivalent to $f(g(x))$, you first apply g and then f
- $g ∘ f$ will usually be different from $f ∘ g$, but not always.
- In `java.util.function.Function` we could use both its default methods `f.compose(g)` and `g.andThen(f)` to 
  implement $f ∘ g$

#### functions of several arguments
- offically there is no such thing as a function of more than one argument
- e.g. in case of $f(x,y) = x + y$, we should interpret this as a single pair argument whose elements are added.
- In general multiple arguments can be seen as the elements of a singe tuple function argument.

#### Function currying
- we can rewrite the function of a tuple $f((x,y)) = x + y$ to
- $f(x) (y) = g(y)$ where $g(y) = x + y$
- This means applying f for a certain value of x results in a new function g that adds the given value of x
  to all y arguments that are passed in:
  - $g(y) = x + y$ where x is no longer a variable, but a constant.
- The codomain of f is no longer a set of numbers, but a set of functions, each with another value for their constant x.
- $f(x)(y)$ is the _curried_ form of the function $f(x,y)$
- Furthermore, a function that has another function as a result, or takes another function as its argument is called 
  a _higher-order_ function.

#### Partially applied functions
- e.g. $f(rate, price) = price (1 + rate/100)$ to express the price with the value added tax with rate expressed as a 
  percentage.
- we could express this as a curried function for all products with the same vat of 9%
- $f(rate) (price), rate = 9%$, which is sometimes called a _partially applied function_
  - $f(9) (price) = price (1 + 0.09)$
  - as there are lots of products each with their own price, but only a limited set of vat rates this partially applied 
    function is convenient. The fixed rate doesn't have to be inputted for every function call, which reduces the chance
    of errors.
- The other order in which we could express the function would be $g(price, rate)$ leading to $g(price)(rate)$.
- The latter curried or partially applied function would not be so practical, but is still a possibility.

## §2.2 Functions in Java
In Java everything is defined inside a class, therefore functions have to be implemented as either instance methods or 
class methods (designated with the `static` keyword). The main difference is, that an instance method is able to access 
the object's state implicitly, which is less transparent than a class method that is only able to access input through 
its parameters (and still also class variables, again marked with the `static` keyword).

### §2.2.1 Functional methods
For a method (of either instance or class variety) to be functional it must meet the following requirements.
- It must not mutate anything outside the function. No internal mutation may be visible from the outside.
- It must not mutate its argument.
- It must not throw errors or exceptions.
- It must always return a value.
- It must be consistent: when called with the same argument, it must always return the same result.

In the examples to evaluate look for these indications that violate the rules:
- access to any variables used as input beside the parameters: these could be altered by other code and thus violate the
  rule of consistent return values.
  - immutable variables (constants) which cannot be changed after object instantiation are allowed.
- any condition that may throw an exception.
- any modification to the argument that will be visible by the calling code. 
  - So primitive type arguments that are passed by value may be reassigned within the methods body; this won't be 
    visible from the outside,
  - (collections of) objects may not have their state modified as they are passed by reference and this will be visible
    from outside the method.
    - e.g. adding elements to, or removing elements from a collection, changing attributes through setter methods
    - note that reassignment will not change the state of the original objects passed in.

**All instance methods can be replaced with static methods by adding an argument of the type of the enclosing class.**
```java
    public static int applyTax3(FunctionalMethods instance, int a){
        return a / 100 * (100 + instance.taxPercentage);
    }
```
- For the complete example see 
  - [com.fpinjava.functions.FunctionalMethods](../fpinjava-parent/fpinjava-usingfunctions-exercises/src/main/java/com/fpinjava/functions/FunctionalMethods.java) and
  - [com.fpinjava.functions.FunctionalMethodsTest](../fpinjava-parent/fpinjava-usingfunctions-exercises/src/test/java/com/fpinjava/functions/FunctionalMethodsTest.java)
- Instance methods accessing class properties may be considered as having the enclosing class instance as an implicit 
  parameter. 
- Methods that don’t access the enclosing class instance may be safely made static. 
- Methods accessing the enclosing instance may also be made static if their implicit parameter (the enclosing instance)
  is made explicit.

#### Object notation vs. functional notation
- instance methods accessing instance variables may be considered as having the enclosing class instance as an implicit
parameter. 
- Methods that don’t access the enclosing class instance may be safely made static. 
- Methods accessing the enclosing instance may also be made static if their implicit parameter (the enclosing instance)
  is made explicit.

- See [com.fpinjava.introduction.listing01_06.Payment](../fpinjava-parent/fpinjava-introduction/src/main/java/com/fpinjava/introduction/listing01_06/Payment.java)
  to see both `combine` method varieties implemented.
- and [com.fpinjava.introduction.listing01_06.PaymentCombineTest](../fpinjava-parent/fpinjava-introduction/src/test/java/com/fpinjava/introduction/listing01_06/PaymentCombineTest.java)
  to see how both are called.
- The instance method can be more easily chained to combine many payments, compare
  ```java
  Payment newPayment = p0.combine(p1).combine(p2).combine(p3);
  ```
  with
  ```java
  Payment newPayment = combine(combine(combine(p0, p1), p2), p3);
  ```
  
### §2.2.2 Java functional interfaces and anonymous classes
Generally, in Java you cannot compose methods at runtime without applying them first, because they are a part of the 
class in which they were defined. However, there is a way around this.
You can declare an interface defining a single method. The interface type can be passed into another method as
argument as an anonymous inner class implementing the method. This trick is already in use with the AWT and Swing GUI 
with event handler interfaces and with multithreading using the Runnable and Callable interface.
```java
public interface Function {
    int apply(int arg);
}
```
You can implement this function with an anonymous inner class:
```java
Function triple = new Function() {
    @Override
    public int apply(int arg) {
        return arg * 3;
    }
};

Function square = new Function() {
  @Override
  public int apply(int arg) {
    return arg * arg;
  }
};
```

### §2.2.3 Composing functions
We are already familiar with composing the application of functions:
```java
System.out.println(square.apply(triple.apply(2)));
```

Composing the functions themselves would involve a binary operation with a tuple of two Function type parameters:
```java
Function compose(final Function f1, final Function f2) {
    return new Function() {
        @Override
        public int apply(int arg) {
            return f1.apply(f2.apply(arg));
        }
    };
}

System.out.println(compose(triple, square).apply(3));
```
Now compose is a genuine higher order function returning a new function based on the two functions as arguments.

### §2.2.4
We can make our function more generally applicable by using parameterized types using generics. This turns the function 
into a polymorphic one.
```java
public interface Function<T, U> {
    U apply(T arg);
}
```
We can rewrite our triple and square functions as follows:
```java
Function<Integer, Integer> triple = new Function<>() {
    @Override
    public Integer apply(Integer arg) {
        return arg * 3;
    }
};

Function<Integer, Integer> square = new Function<>() {
  @Override
  public Integer apply(Integer arg) {
    return arg * arg;
  }
};
```

### §2.2.5 Simplifying the code by using lambdas
Lambdas don’t change the way the Function interface is defined, but they make implementing it much simpler:
```java
Function<Integer, Integer> triple = x -> x * 3;
Function<Integer, Integer> square = x -> x * x;
```
Lambdas can dispense with type references, because they implement a method in a functional interface. A functional 
interface is any interface that declares only one abstract method. Since Java 8, the compiler is therefore able to infer
the types of the lambda expression from the abstract method declaration. An interface with more than one abstract method
wouldn't work, because than the compiler wouldn't know which abstract method to use to infer the types from.

See for all details about lambda expressions and method references:
[https://github.com/wjc-van-es/java-8-func-prog/blob/master/src/main/java/nl/vea/functionalp/examples/m02/lambda-expression-details.md](https://github.com/wjc-van-es/java-8-func-prog/blob/master/src/main/java/nl/vea/functionalp/examples/m02/lambda-expression-details.md)

## §2.3 Advanced function features