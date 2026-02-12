# Intérprete de Bitcoin Script

Proyecto de Algoritmos y Estructuras de Datos - Universidad del Valle de Guatemala

## Descripción

Implementación de un intérprete para un subconjunto de Bitcoin Script que permite validar scripts de bloqueo (scriptPubKey) y desbloqueo (scriptSig).

## Equipo

- Cristopher Javier Chávez Toc - 25199
- Mauricio Adrian Corado Castañeda - 25218
- Joseph Alfredo Gongora Giron - 25051

## Opcodes Implementados

- Literales: `OP_0`, `OP_1..OP_16`, `PUSHDATA`
- Stack: `OP_DUP`, `OP_DROP`
- Comparación: `OP_EQUAL`, `OP_EQUALVERIFY`
- Criptografía (mock): `OP_HASH160`, `OP_CHECKSIG`

## Tecnologías

- **Lenguaje:** Java 17+
- **Testing:** JUnit 5
- **Java Collections:** `ArrayDeque`, `ArrayList`

## Estructura del Proyecto
```
PROYECTO1-BITCOINSCRIPT/
│
├── .gitignore
├── README.md
│
└── src/
    └── main/
        └── java/
            └── bitcoinscript/
                │
                ├── Main.java
                │
                ├── controller/
                │   └── Controller.java
                │
                ├── crypto/
                │   └── CryptoMock.java
                │
                ├── engine/
                │   ├── BitcoinStack.java
                │   └── ScriptEngine.java
                │
                ├── opcodes/
                │   ├── OpCode.java (interface)
                │   ├── OpCodeFactory.java
                │   ├── LiteralData.java
                │   ├── OpDup.java
                │   ├── OpEqualVerify.java
                │   └── OpHash160.java
                │
                └── view/
                    └── View.java
```