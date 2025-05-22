# 💱 Conversor de Monedas con Exportación a TXT

Este es un programa en Java que permite convertir una cantidad de dinero de una moneda a otra utilizando la API de [ExchangeRate API](https://www.exchangerate-api.com/), además de mostrar el tipo de cambio actual de una moneda base frente a otras. El resultado de la conversión puede ser exportado a un archivo `.txt`.

## 📌 Características

- Conversión entre dos monedas usando tasa de cambio actual.
- Consulta de tasas de cambio frente a una moneda base (USD por defecto).
- Exportación de los resultados a un archivo `resultado.txt`.
- Separación clara de responsabilidades según los principios de la Programación Orientada a Objetos.
- Manejo básico de errores y excepciones.

---

## 🏗️ Estructura del proyecto

ConversorMoneda/<br>
├── Main.java # Punto de entrada del programa <br>
├── ConversorMoneda.java # Lógica del menú y flujo principal<br>
├── ServicioCambio.java # Clase para consumir la API<br>
├── GestorArchivo.java # Clase para exportar datos a .txt<br>
├── RespuestaConversion.java # Clase para deserializar la respuesta de conversión<br>
├── RespuestaTasas.java # Clase para deserializar la respuesta de tasas múltiples<br>
└── gson-2.11.0.jar # Librería GSON para parsear JSON<br>


---

## 🧰 Requisitos

- Java 17 o superior
- Conexión a Internet
- API Key gratuita desde [ExchangeRate API](https://www.exchangerate-api.com/)
- Librería GSON de Google

---

## ⚙️ Cómo usar

1. **Clona el repositorio o copia los archivos del proyecto.**
2. **Descarga la librería GSON:**  
   [GSON - Descargar .jar](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar)
3. **Compila el proyecto desde consola:**

```bash
javac -cp gson-2.11.0.jar *.java
📝 En Linux/Mac usa : en lugar de ; para separar el classpath:
java -cp .:gson-2.11.0.jar Main
```
<p align="left">
<img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
</p>
