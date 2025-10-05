# 🚀 CP5 Cloud - WebAPP + SQL Server

Este projeto automatiza o processo de configuração e deploy de um WebAPP + SQL Server no **Microsoft Azure**, utilizando **GitHub Actions** e **Application Insights**.

---

## ⚙️ Passo a Passo para Executar

### 1️⃣ Acesse o Cloud Shell da Azure
Abra o terminal do **Cloud Shell** diretamente no portal do Azure.

### 2️⃣ Clone o Repositório
```bash
git clone https://github.com/guiakiraa/cp5-cloud.git
```

### 3️⃣ Entre na Pasta do Projeto
```bash
cd cp5-cloud
```

### 4️⃣ Execute o Script PowerShell
No Cloud Shell, execute o script `.ps1`:
```bash
./create-sql-server.ps1
```

---

### 5️⃣ Adicione a Extensão do Application Insights
```bash
az extension add --name application-insights
```

---

### 6️⃣ Dê Permissão de Execução ao Script .sh
```bash
chmod +x script.sh
```

---

### 7️⃣ Execute o Script .sh
```bash
./script.sh
```

---

## 🔐 Configuração dos Secrets no GitHub

1. Vá até o repositório no GitHub.  
2. Acesse: **Settings → Secrets → Actions → New repository secret**.  
3. Crie os seguintes secrets:

| Nome do Secret               | Descrição                          |
|------------------------------|------------------------------------|
| `SPRING_DATASOURCE_URL`      | jdbc:sqlserver://sqlserver-dimdim.database.windows.net:1433;database=dimdimdb;user=admsql@sqlserver-rm9999;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;              |
| `SPRING_DATASOURCE_USERNAME` | admsql          |
| `SPRING_DATASOURCE_PASSWORD` | Fiap@2tdsvms            |

---

## 🧩 Atualização do Workflow do GitHub Actions

1. Abra o arquivo `.yml` gerado automaticamente pelo GitHub Actions (exemplo: `.github/workflows/main.yml`).
2. Logo **abaixo da linha `mvn clean install`**, adicione o seguinte trecho:

```yaml
env:
  SPRING_DATASOURCE_URL: ${{ secrets.SPRING_DATASOURCE_URL }}
  SPRING_DATASOURCE_USERNAME: ${{ secrets.SPRING_DATASOURCE_USERNAME }}
  SPRING_DATASOURCE_PASSWORD: ${{ secrets.SPRING_DATASOURCE_PASSWORD }}
```

---

## ✅ Conclusão

Após seguir todos os passos acima:

- Sua aplicação será configurada e implantada no Azure.  
- O monitoramento via **Application Insights** estará habilitado.  
- As credenciais do banco de dados estarão protegidas nos **Secrets do GitHub**.

---

### 💡 Dica

Caso encontre algum erro durante a execução, verifique:
- Se os scripts `.ps1` e `.sh` estão com permissão de execução.  
- Se os secrets foram configurados corretamente no GitHub.  
- Se o Azure Cloud Shell está autenticado na conta certa.

