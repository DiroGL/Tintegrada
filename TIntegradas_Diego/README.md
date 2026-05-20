# DevelopersClub - Comparador de Tarifas Telefónicas

Este proyecto es una aplicación de escritorio desarrollada como **trabajo académico** durante mi formación superior. El objetivo principal de la práctica fue consolidar conceptos de programación orientada a objetos, persistencia nativa y diseño de interfaces gráficas funcionales en Java.

> ⚠️Este código refleja mis primeras etapas de aprendizaje académico. No está diseñado bajo estándares profesionales de producción actuales (como arquitecturas limpias o inyección de dependencias), sino enfocado a cumplir con los requisitos académicos de la asignatura.

---

## 🚀 Características del Proyecto

La aplicación simula un portal de gestión y comparación de tarifas y ofertas de telecomunicaciones:

* **Sistema de Acceso:** Control de autenticación de usuarios (Login y Registro) con validaciones básicas de datos en cliente (como el formato del DNI).
* **Visualización de Datos:** Consulta de catálogos de compañías, ofertas y números de atención al cliente.
* **Filtros y Consultas:** Motor de búsqueda personalizado para filtrar ofertas según rangos de megabytes específicos.
* **Algoritmos de Ordenación:** Implementación de ordenación dinámica de ofertas mediante `Collections.sort` utilizando criterios de precio y permanencia del contrato.

---

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java SE
* **Interfaz Gráfica (GUI):** Java Swing y AWT (Diseño basado en contenedores, eventos y `Layouts`).
* **Base de Datos:** MySQL / MariaDB (Persistencia de datos relacionales).
* **Acceso a Datos:** **JDBC puro (Java Database Connectivity)**. Gestión manual de conexiones mediante controladores nativos (`DriverManager`, `Statement`, `ResultSet`).

---

## 📂 Estructura del Repositorio de la Interfaz

* `MenuGUI.java`: Clase principal que actúa como controlador y vista de la aplicación, gestionando el ciclo de vida de las ventanas, los paneles (`JPanel`) y los escuchadores de eventos (`ActionListeners`).
* Integración con la capa backend encargada de realizar las consultas SQL nativas a través del conector JDBC (`BD_Tintegrada`).

---

## ⚙️ Requisitos para la Ejecución Local

1. Disponer de un entorno de ejecución de Java (JDK 8 o superior).
2. Servidor de base de datos local (ej. XAMPP / phpMyAdmin) con la base de datos `tintegrada` levantada e importada desde el archivo `.sql` del proyecto.
3. El driver conector de MySQL para JDBC (`mysql-connector-java`) añadido al *Build Path* del proyecto.
