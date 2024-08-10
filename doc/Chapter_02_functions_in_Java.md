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
- e.g. $f(rate, price) = price (1 + rate/100)$ to express the price with the value added tax as rate expressed as a 
  percentage.
- we could express this as a curried function for all products with the same vat of 9%
- $f(rate) (price), rate = 9%$, which is sometimes called a _partially applied function_
  - $f(9) (price) = price (1 + 0.09)$
  - as there are lots of products each with their own price, but only a limited set of vat rates this partially applied 
    function is convenient. The fixed rate doesn't have to be inputted for every function call, which reduces the chance
    of errors.
- The other order in which we could express the function would be $g(price, rate)$ leading to $g(price)(rate).
- The latter curried or partially applied function would not be so practical, but is still a possibility.

## §2.2 Functions in Java