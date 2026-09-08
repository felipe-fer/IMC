# Calculadora de IMC - Android App

> Aplicativo desenvolvido em **Java** para dispositivos Android que calcula o Índice de Massa Corporal (IMC) do usuário, realiza a classificação automática baseada nos parâmetros da OMS e direciona dinamicamente para telas de resultados personalizadas.

---

## 📱 Sobre o Projeto

Este projeto foi construído para consolidar conceitos fundamentais do desenvolvimento Android nativo. O aplicativo recolhe dados de entrada (Nome, Peso e Altura), aplica a fórmula padrão de cálculo de IMC e utiliza navegação baseada em intents explícitas para direcionar o fluxo do usuário para 6 activities de resultados distintas, cada uma contendo orientações e mensagens motivacionais específicas.

---

## 🚀 Funcionalidades

- **Entrada de Dados Validada:** Campos específicos para Nome, Peso (kg) e Altura (metros) com tratamento para evitar campos vazios ou valores inválidos.
- **Cálculo Dinâmico de IMC:** Aplicação da fórmula matemática padrão: $\text{IMC} = \frac{\text{peso}}{\text{altura} \times \text{altura}}$.
- **Múltiplas Activities de Resultado:** Direcionamento automatizado para telas customizadas conforme a faixa de classificação.
- **Passagem de Dados (Intents):** Envio seguro do nome do usuário e do valor calculado do IMC entre a Activity principal e as telas de resultado.
- **Navegação de Retorno:** Botão dedicado para redefinir o fluxo e retornar à tela principal de forma limpa.

---

## 🛠️ Tecnologias e Conceitos Utilizados

- **Linguagem:** Java
- **Ambiente de Desenvolvimento:** Android Studio
- **Componentes de UI:** `EditText`, `TextView`, `Button`, layouts responsivos (Linear/Constraint Layout)
- **Gerenciamento de Fluxo:** `Intent` explícita, Extras (`putExtra`, `getDoubleExtra`), ciclo de vida de Activities e limpeza de pilha
