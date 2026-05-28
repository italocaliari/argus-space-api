<div align="center">
  <h1>🛰️ Sistema Argus</h1>
  <p><strong>Monitoramento Orbital e Evasão Autônoma de Detritos Espaciais</strong></p>
  
  <img src="https://img.shields.io/badge/FIAP-Global%20Solution-blue?style=for-the-badge" alt="FIAP GS">
  <img src="https://img.shields.io/badge/JDK-Amazon%20Corretto%2021-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Amazon Corretto 21">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=spring" alt="Spring Boot">
</div>

<hr>

<h2>📋 Sobre o Projeto</h2>
<p>
  O <strong>Sistema Argus</strong> é uma solução robusta desenvolvida em Java para o monitoramento em tempo real de satélites em órbitas baixas (LEO). A aplicação utiliza inteligência e cálculos matemáticos orbitais para prever riscos críticos de colisão com detritos espaciais e engajar protocolos de manobra evasiva autônoma.
</p>

<h2>🚀 Arquitetura e Tecnologias</h2>
<p>A API foi construída seguindo as melhores práticas de desenvolvimento, Clean Code e padrões de mercado:</p>

<ul>
  <li><strong>Amazon Corretto 21 (OpenJDK)</strong>: Ambiente de execução de produção de alta performance e suporte a longo prazo (LTS).</li>
  <li><strong>Spring Boot 3.x</strong>: Framework para criação da API RESTful eficiente.</li>
  <li><strong>Spring Data JPA & Hibernate</strong>: Mapeamento objeto-relacional e abstração de persistência.</li>
  <li><strong>Banco de Dados H2</strong>: Banco em memória RAM ideal para execução e testes rápidos locais.</li>
</ul>

<h3>Arquitetura do Código (Camadas)</h3>
<table border="1" width="100%">
  <tr>
    <th>Pacote (Package)</th>
    <th>Responsabilidade</th>
  </tr>
  <tr>
    <td><code>br.com.fiap.argus.domain</code></td>
    <td>Modelagem de dados baseada em POO (Herança com <code>SpaceObject</code>, <code>Satellite</code> e <code>SpaceDebris</code>).</td>
  </tr>
  <tr>
    <td><code>br.com.fiap.argus.controller</code></td>
    <td>Exposição dos Endpoints da API REST para recebimento de métricas.</td>
  </tr>
  <tr>
    <td><code>br.com.fiap.argus.service</code></td>
    <td>Motor matemático de processamento de colisão e regras de negócio.</td>
  </tr>
  <tr>
    <td><code>br.com.fiap.argus.repository</code></td>
    <td>Interface de comunicação direta com o Banco de Dados via JPA.</td>
  </tr>
  <tr>
    <td><code>br.com.fiap.argus.dto</code></td>
    <td>Objetos de transferência de dados (Records) para requisições e respostas limpas.</td>
  </tr>
</table>

<hr>

<h2>🛠️ Como Testar a Aplicação</h2>
<p>A API expõe o seguinte endpoint para análise de telemetria:</p>

<blockquote>
  <strong>POST</strong> <code>http://localhost:8080/api/argus-collision/analyze</code>
</blockquote>

<h3>Exemplo de Payload de Entrada (JSON)</h3>
<pre><code>
{
  "targetObjectName": "Starlink-Ford-12",
  "currentLatitude": -23.5631,
  "currentLongitude": -46.6543,
  "currentAltitude": 400.0
}
</code></pre>

<h3>Exemplo de Resposta (Risco Crítico)</h3>
<p>Caso a distância orbital do detrito seja menor que 5km, o sistema aciona o desvio e consome o combustível do satélite:</p>
<pre><code>
{
  "message": "Ação evasiva autônoma executada com sucesso pelo sistema Argus. Dados persistidos.",
  "alertData": {
    "alertId": "dc07c7b2-ef7a-41cb-b42f-8130da35e30a",
    "satelliteName": "Starlink-Ford-12",
    "riskLevel": "VERMELHO (Risco Crítico de Impacto)",
    "calculatedSafeVector": "Trajetória Azul Ativada: Altitude recalculada de segurança para 415.0km",
    "timestamp": "2026-05-28T20:19:03.6268257"
  }
}
</code></pre>

<hr>

<h2>📸 Evidências de Teste</h2>
<p>Resultado da integração e validação do endpoint via terminal:</p>

<div align="center">
  <img <img width="1098" height="426" alt="Captura de tela 2026-05-28 203136" src="https://github.com/user-attachments/assets/333ff9a0-b415-4b18-b0d2-5b8bb5fd1dda" />
</div>

<hr>

<h2>👥 Integrantes do Grupo</h2>
<p>Desenvolvido por:</p>
<ul>
  <li><strong>Danilo Gronski Wendler</strong></li>
  <li><strong>Italo Caliari Silva</strong></li>
  <li><strong>Júlio César Ruiz Zequin</strong></li>
  <li><strong>Pedro Henrique Muzel Santos</strong></li>
  <li><strong>Vitor Montemor Ismael</strong></li>
</ul>

<div align="center">
  <p><em>Global Solution 2026 - Engenharia de Software FIAP</em></p>
</div>
