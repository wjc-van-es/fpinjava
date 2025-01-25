<style>
body {
  font-family: "Gentium Basic", Cardo , "Linux Libertine o", "Palatino Linotype", Cambria, serif;
  font-size: 100% !important;
  padding-right: 12%;
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

</style>

# Chapter 1 - What is functional programming

## Definition
A pure function returns a result based on the input parameters and nothing else. Therefore,
- it contains no side effects,
- makes the order of execution irrelevant and doesn't need a prescribed flow of control.

### Side effects take many forms
- reassignment of variables,
- i/o: logging messages to system output or the filesystem,
- i/o: accepting input from a file, http request, mouse or keyboard,
- i/o: rendering output to a screen,
- throwing exceptions.

It is hard to avoid all side effects, but the rule is limited to _observable_ side effects, where a function is treated
as a black box. So we can use local variable reassignments inside a function as long this isn't shared with other parts
of the code. This is also valid for function parameters in Java as they are passed by value and the code calling the
function won't notice any parameter reassignments inside the function.

- Even the varying time it takes to execute a function is a side effect. Also, errors like stack-overflow and
  out-of-memory cannot be avoided completely.
- So a more precise rule would be to avoid all _intentional side effects_ - we can avoid an exception, but not an error.

Therefore, we can conclude that a pure function is devoid of all _observable, intentional side effects_.

A pure function without any side effects is _referential transparant_. You can substitute a function call with its 
returned value, without changing the program's behavior.

A traditional imperative program is doing something to an initial state, through multiple transitions arriving at a 
desired end state.
This is called state mutation and consists of
- testing conditions,
- mutating variables,
- branching,
- and finally returning a result value.

## 1.2 Writing useful programs with no side effects
As interactions with the outside world, which are all considered intentional side effects, are ultimately still 
necessary to have a useful program we cannot avoid side effects completely.
- We can organize side effects in a way that we limit these at the boundaries of our program and express the rest as
  pure functions.
- 

## 1.3 How referential transparency makes programs safer
Code that doesn't mutate or depend on the external world is said to be referentially transparent.
- self-contained - no external dependencies
  - no external devices like databases, file systems, or networks.
- deterministic - always returning the same value for the same argument
- it will never throw an exception (it can throw an error)
- it won't create conditions that may cause other parts of the code to fail unexpectedly
  - it won't change shared data (like global variables or even function arguments)
  - therefore, it cannot raise concurrent access exceptions either

## 1.4 The benefits of functional programming
- deterministic functions are easier to reason about
- absence of side effects makes mocking unnecessary
- more modular
- easier composition and recombination, because of referential transparency
  - combining base functions into higher-level ones

## 1.5 Using the substitution model to reason about programs
it’s always possible to replace a function call, or any referentially transparent expression, with its value.

# 1.6 Applying functional principles to a simple example
