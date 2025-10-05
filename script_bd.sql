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