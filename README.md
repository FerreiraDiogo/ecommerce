# ecommerce
Backend em java para um pseudo e-commerce desenvovlido para fins de prática

**Requisitos Funcionais Detalhados:**
- **Gestão de Produtos:**
    - [ x ] Endpoint POST /api/v1/products com validação de categoria, preço (> 0), nome (3-100 chars)
    - [ ] Endpoint GET /api/v1/products com paginação (page, size), filtros (categoria, preço min/max, nome)
    - [ ] Upload de imagens (máx 5 por produto, formatos: jpg, png, webp, tamanho < 2MB)
    - [ ] Sistema de tags personalizáveis por produto
- **Processamento de Pedidos:**
    - Carrinho de compras com sessão temporária (TTL 30min)
    - Aplicação de cupons de desconto com regras (percentual, valor fixo, produto específico)
    - Cálculo automático de frete via CEP (integração com API externa mock)
    - Estados do pedido: PENDING → PAID → PROCESSING → SHIPPED → DELIVERED
- **Sistema de Pagamentos:**
    - Integração com 3 providers distintos (PayPal, Stripe, PagSeguro) usando Strategy Pattern
    - Retry automático com exponential backoff em falhas
    - Webhook para confirmação de pagamento
    - Estorno automático após 7 dias se pedido não processado
- **Notificações:**
    - Email: confirmação pedido, mudança status, promoções
    - SMS: apenas para mudanças críticas de status
    - Push notifications via Firebase (simulado)
    - Template engine para personalização de mensagens

**Requisitos Não Funcionais:**
- Arquitetura hexagonal com camadas bem definidas (domain, application, infrastructure)
- Cobertura de testes > 85% (unit + integration + architecture tests com ArchUnit)
- Documentação OpenAPI 3.0 completa com exemplos
- Tempo de resposta < 200ms para consultas, < 500ms para comandos
- Suporte a 1000+ usuários simultâneos

**Ferramentas de Validação:**
- JMeter scripts para testes de carga (1000 usuários simultâneos)
- ArchUnit para validação de arquitetura
- Jacoco para cobertura de testes
- SpringDoc OpenAPI para documentação
- TestContainers para testes de integração
