az provider register --namespace Microsoft.Web
az provider register --namespace Microsoft.Insights
az provider register --namespace Microsoft.OperationalInsights
az provider register --namespace Microsoft.ServiceLinker
az provider register --namespace Microsoft.Sql

$RG = "rg-dimdim"
$LOCATION = "brazilsouth"
$SERVER_NAME = "sqlserver-dimdim"
$USERNAME = "admsql"
$PASSWORD = "Fiap@2tdsvms"
$DBNAME = "dimdimdb"

az group create --name $RG --location $LOCATION
az sql server create -l $LOCATION -g $RG -n $SERVER_NAME -u $USERNAME -p $PASSWORD --enable-public-network true
az sql db create -g $RG -s $SERVER_NAME -n $DBNAME --service-objective Basic --backup-storage-redundancy Local --zone-redundant false
az sql server firewall-rule create -g $RG -s $SERVER_NAME -n AllowAll --start-ip-address 0.0.0.0 --end-ip-address 255.255.255.255

Invoke-Sqlcmd -ServerInstance "$SERVER_NAME.database.windows.net" `
              -Database "$DBNAME" `
              -Username "$USERNAME" `
              -Password "$PASSWORD" `
              -Query @"
CREATE TABLE [dbo].[endereco] (
    id BIGINT NOT NULL IDENTITY,
    logradouro VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE [dbo].[filial] (
    id BIGINT NOT NULL IDENTITY,
    nome VARCHAR(100) NOT NULL,
    fk_endereco BIGINT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE [dbo].[filial] ADD CONSTRAINT FK_FILIAL_ENDERECO FOREIGN KEY (fk_endereco) REFERENCES [dbo].[endereco] (id);
"@
