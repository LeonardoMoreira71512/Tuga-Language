# Tuga-Language

Tuga is a toy programming language designed for educational purposes, built as part of a Compilers course project. It resembles C and Java, but all keywords and syntax are written in Portuguese.

## Introduction

This project extends the Tuga language to support function declaration and local variables. As a result, the symbol table must handle nested scopes and retain relevant information for all types of symbols, including global/local variables, function names, and arguments.

Two new instructions are introduced to support function features:
- Function calls
- `retorna` (return)

The virtual machine also gained new instructions to handle function execution using a stack and frame pointer.

A function may be called before its declaration in the code.

## Language Structure

A valid Tuga program consists of:
- A (possibly empty) list of global variable declarations
- Followed by one or more function declarations
- **One of the functions must be named `principal()`**, which acts as the program's entry point

### Rules and Features

The Tuga language follows these rules:
- All code must be inside functions
- Blocks start with `inicio` and end with `fim`
- Variable declarations must come before statements in each block
- Supports local scopes and nested blocks
- Function arguments are passed by value
- Functions may return `inteiro`, `real`, `booleano`, `string` or nothing (`vazio`)
- Static type checking with clear error messages
- Expressions must be type-consistent (e.g., can't add `inteiro` to `string`)
- Calling a void function as part of an expression is invalid

## Virtual Machine (SVM)

The virtual machine uses a **Frame Pointer (FP)** and stack frames to support function calls. It includes 7 new instructions:

| Opcode | Name    | Arg  | Description                                                                 |
|--------|---------|------|-----------------------------------------------------------------------------|
| 46     | `lalloc`| n    | Allocates `n` local positions on the stack, initialized with `NULO`         |
| 47     | `lload` | addr | Pushes value from `Stack[FP + addr]`                                       |
| 48     | `lstore`| addr | Pops value into `Stack[FP + addr]`                                         |
| 49     | `pop`   | n    | Pops `n` elements from the stack                                            |
| 50     | `call`  | addr | Creates a new frame, saves `FP` and return address, jumps to `addr`        |
| 51     | `retval`| n    | For non-void functions: pops value, clears locals, restores state, pushes return |
| 52     | `ret`   | n    | For void functions: clears locals, restores state                          |

## Running the Project

1. Make sure to **add the ANTLR jar** (`antlr-4.13.2-complete.jar`) to your Project Structure in IntelliJ
2. Set **Language Level to 21**
3. Inputs can be passed via:
   - **Command-line argument**: path to a `.tuga` file (e.g. `inputs/ex1.tuga`)
   - **Standard input (stdin)**: paste the code and end with `Ctrl+D` (Linux/macOS) or `Ctrl+Z` (Windows)

### IntelliJ Run Configuration Example

- Program arguments: `inputs/Ftp3.tuga`
- Working directory: your project folder

## Example
```tuga
funcao principal()
inicio
  escreve sqrsum(3,2);
fim

funcao sqrsum( a: inteiro, b: inteiro ): inteiro
inicio
  s: inteiro;
  s <- sqr(a + b);
  retorna s;
fim

funcao sqr( x: inteiro ): inteiro
inicio
  retorna x * x;
fim
```

### Output
```
25
```

## Additional Examples

### 🔢 Example 1: Sum of three integers
```tuga
funcao soma3(a: inteiro, b: inteiro, c: inteiro): inteiro
inicio
    retorna a + b + c;
fim

funcao principal()
inicio
    escreve soma3(1, 2, 3);
fim
```
**Output:**
```
6
```

---

### 🔁 Example 2: Nested function calls
```tuga
funcao inc(x: inteiro): inteiro
inicio
    retorna x + 1;
fim

funcao dobro(x: inteiro): inteiro
inicio
    retorna x * 2;
fim

funcao principal()
inicio
    escreve dobro(inc(4));
fim
```
**Output:**
```
10
```

---

### 📏 Example 3: Max function using if/else
```tuga
funcao max(a: inteiro, b: inteiro): inteiro
inicio
    se (a > b) retorna a;
    senao retorna b;
fim

funcao principal()
inicio
    escreve max(7, 4);
fim
```
**Output:**
```
7
```

---

### 🧪 Example 4: Semantic errors
```tuga
zzz: inteiro;

funcao principallll()
inicio
    n: inteiro;
    n: booleano;
    n <- fun(1,2,3);
    fun(1,2);
    hello("Maria");
    hello(5);
    n <- hello("Maria");
    n <- hello("Maria") + 44;
    fun <- 8;
    n <- misterio(n);
fim

funcao hello(s: string)
inicio
    escreve "Hello " + s;
fim

funcao zzz(x: inteiro): real
inicio
    retorna x + 1;
fim

funcao hello()
inicio
    escreve "Hello";
fim

funcao fun(x: inteiro, y: inteiro): inteiro
inicio
    b: booleano;
    b <- hello;
    retorna x + y;
fim
```
**Expected Errors:**
```
erro na linha 6: 'n' ja foi declarado
erro na linha 7: 'fun' requer 2 argumentos
erro na linha 8: valor de 'fun' tem de ser atribuido a uma variavel
erro na linha 10: '5' devia ser do tipo string
erro na linha 11: operador '<-' eh invalido entre inteiro e vazio
erro na linha 12: operador '+' eh invalido entre vazio e inteiro
erro na linha 13: 'fun' nao eh variavel
erro na linha 14: 'misterio' nao foi declarado
erro na linha 22: 'zzz' ja foi declarado
erro na linha 27: 'hello' ja foi declarado
erro na linha 35: 'hello' nao eh uma variavel
erro na linha 38: falta funcao principal()
```

---


## Debugging and Trace Output

The Tuga compiler and virtual machine are integrated in a single Java class: `TugaCompileAndRun`. This class performs **lexing**, **parsing**, **semantic analysis**, **code generation**, saves the bytecodes to file, and **immediately runs the virtual machine** — all in one go.

### Flags for Debugging

You can enable detailed output by modifying the following flags in `TugaCompileAndRun.java`:

```java
static boolean showLexerErrors = false;
static boolean showParserErrors = false;
static boolean showTypeCheckingErrors = true;
static boolean showAsmGeneratedCode = true;
static boolean showByteCodes = false;      // Show raw bytecode from bytecodes.bc
static boolean showStackTrace = true;      // Show step-by-step VM stack trace
```

- Set `showByteCodes = true` to view the contents of the generated `bytecodes.bc`
- Set `showStackTrace = true` to print a **full execution trace** including the current stack, instruction pointer (`IP`) and frame pointer (`FP`)

These variables are used when invoking the SVM:
```java
byte[] bytecodes = SvmUtil.loadBytecodes("bytecodes.bc");
Svm vm = new Svm(bytecodes, showStackTrace);
vm.setFunctionInfos(codeGen.getFunctionInfos());
vm.run();
```

### Example Program (Trace Enabled)

```tuga
funcao sqr( x: inteiro ): inteiro
inicio
    retorna x * x;
fim

funcao sqrsum( a: inteiro, b: inteiro ): inteiro
inicio
    s: inteiro;
    s <- sqr(a + b);
    retorna s;
fim

funcao principal()
inicio
   escreve sqrsum(3,2);
fim
```

### Output
```
*** Constant pool ***
*** Instructions ***
0: call 14
1: halt
...
18: ret 0
*** VM output ***
                     Globals: []
                     Stack:   []
                     IP: 0  FP: 0

 0: call 14             
                     Stack: [ 0 1 ]
                     IP: 14  FP: 0

14: iconst 3            
                     Stack: [ 0 1 3 ]
...
17: iprint
25
```

> This makes it easy to debug function calls, stack frame changes, and return values.
