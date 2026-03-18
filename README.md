# Intérprete de Bitcoin Script

Proyecto de Algoritmos y Estructuras de Datos - Universidad del Valle de Guatemala

## Descripción

Implementación de un intérprete de un subconjunto de Bitcoin Script que simula la validación de transacciones mediante la ejecución secuencial de opcodes sobre una pila (stack).

## Equipo

- Cristopher Javier Chávez Toc - 25199
- Mauricio Adrian Corado Castañeda - 25218
- Joseph Alfredo Gongora Giron - 25051

## Opcodes Implementados

- Literales: `OP_0`, `OP_1` …, `OP_SWAP`, `OP_OVER`
- Comparación: `OP_EQUAL`, `OP_EQUALVERIFY`, `OP_NOT`, `OP_BOOLAND`, `OP_BOOLOR`
- Criptografía (mock): `OP_HASH160`, `OP_SHA256`
- Aritmética: `OP_ADD`, `OP_SUB`, `OP_NUMEQUALVERIFY`, `OP_LESSTHAN`, `OP_GREATERTHAN`, `OP_LESSTHANOREQUAL`, `OP_GREATERTHANOREQUAL`
- Control de flujo: `OP_IF`, `OP_NOTIF`, `OP_ELSE`, `OP_ENDIF`, `OP_VERIFY`, `OP_RETURN`
- Firma: `OP_CHECKSIG`, `OP_CHECKSIGVERIFY`


## Tecnologías

- **Lenguaje:** Java 17+
- **Testing:** JUnit 5
- **Java Collections:** `ArrayDeque`, `ArrayList`

## Compilar el Proyecto

Compila todos los archivos `.java` del proyecto (excluyendo los tests)

En PowerShell:

```bash
javac -d out (Get-ChildItem src/main/java -Recurse -Filter *.java | Where-Object { $_.FullName -notmatch "Test" } | % FullName)
```

## Ejecutar el Proyecto

En PowerShell:

```bash
java -cp out bitcoinscript.Main
```

## Ejemplo del Interprete
scriptSig:    5 3
scriptPubKey: OP_ADD OP_8 OP_EQUAL


Este script evalúa si `5 + 3 == 8`.

### Ejecución paso a paso (stack)

- [] (inicio)
- [5] (push 5)
- [3,5] (push 3)
- [8] (OP_ADD → 5 + 3)
- [8,8] (OP_8)
- [1] (OP_EQUAL → 8 == 8)

### Resultado

El script es válido porque el valor final en la cima de la pila es distinto de `0`.


## Estructura del Proyecto
```
PROYECTO1-BITCOINSCRIPT/
│
├── docs/
│
│
├── src/
│   ├── main/
│       └── java/
│           └── bitcoinscript/
│               ├── Main.java
│               ├── controller/
│               ├── crypto/
│               ├── engine/
│               ├── opcodes/
│               ├── view/
│               └── tests/
│
│
├── .gitignore
└── README.md
```