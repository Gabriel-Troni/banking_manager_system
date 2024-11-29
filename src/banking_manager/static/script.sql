CREATE DATABASE banking_system;
USE banking_system;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL, 
    cpf CHAR(11) UNIQUE NOT NULL,
    rg VARCHAR(20), 
    salario DECIMAL(10, 2),
    endereco VARCHAR(255)
);

CREATE TABLE conta (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    id_cliente INT,                        
    tipo ENUM('C', 'I') NOT NULL,           
    saldo DECIMAL(10, 2) NOT NULL,        
    montante_minimo DECIMAL(10, 2),            
    deposito_minimo DECIMAL(10, 2),         
    limite DECIMAL(10, 2),                     
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE
);

INSERT INTO cliente (nome, sobrenome, cpf, rg, salario, endereco) VALUES
('João', 'Silva', '12345678901', 'MG1234567', 3000.00, 'Rua A, 123'),
('Maria', 'Oliveira', '23456789012', 'SP2345678', 2500.00, 'Rua B, 234'),
('Carlos', 'Pereira', '34567890123', 'RJ3456789', 4000.00, 'Rua C, 345'),
('Ana', 'Costa', '45678901234', 'MG4567890', 5000.00, 'Rua D, 456'),
('Luiz', 'Santos', '56789012345', 'SP5678901', 3500.00, 'Rua E, 567'),
('Fernanda', 'Almeida', '67890123456', 'RJ6789012', 2800.00, 'Rua F, 678'),
('Ricardo', 'Souza', '78901234567', 'MG7890123', 3200.00, 'Rua G, 789'),
('Camila', 'Lima', '89012345678', 'SP8901234', 4800.00, 'Rua H, 890'),
('Felipe', 'Gomes', '90123456789', 'RJ9012345', 3700.00, 'Rua I, 901'),
('Patrícia', 'Martins', '01234567890', 'MG0123456', 3300.00, 'Rua J, 101'),
('Vitor', 'Rodrigues', '12340987654', 'SP1234098', 4500.00, 'Rua K, 102'),
('Juliana', 'Nunes', '23451098765', 'RJ2345109', 5100.00, 'Rua L, 103'),
('Ricardo', 'Ferreira', '34562109876', 'MG3456210', 4200.00, 'Rua M, 104'),
('Beatriz', 'Teixeira', '45673210987', 'SP4567321', 2900.00, 'Rua N, 105'),
('Eduardo', 'Pinto', '56784321098', 'RJ5678432', 4600.00, 'Rua O, 106'),
('Mariana', 'Machado', '67895432109', 'MG6789543', 5100.00, 'Rua P, 107'),
('Lucas', 'Castro', '78906543210', 'SP7890654', 4400.00, 'Rua Q, 108'),
('Roberta', 'Ribeiro', '89017654321', 'RJ8901765', 3900.00, 'Rua R, 109'),
('Eduarda', 'Moura', '90128765432', 'MG9012876', 5200.00, 'Rua S, 110'),
('Gustavo', 'Silveira', '01239876543', 'SP0123987', 3300.00, 'Rua T, 111');

-- Contas Correntes
INSERT INTO conta (id_cliente, tipo, saldo, limite) VALUES
(1, 'C', 1500.00, 2000.00),
(2, 'C', 2500.00, 3000.00),
(3, 'C', 4000.00, 5000.00),
(4, 'C', 150.00, 1000.00),
(5, 'C', 3500.00, 4000.00),
(6, 'C', 1200.00, 1500.00),
(7, 'C', 10000.00, 12000.00),
(8, 'C', 500.00, 1000.00),
(9, 'C', 7000.00, 8000.00),
(10, 'C', 250.00, 500.00);

-- Contas de Investimento (conta tipo CI)
INSERT INTO conta (id_cliente, tipo, saldo, montante_minimo, deposito_minimo, limite) VALUES
(12, 'I', 15000.00, 1500.00, 500.00, 500.00),
(13, 'I', 8000.00, 1500.00, 500.00, 300.00),
(14, 'I', 20000.00, 1500.00, 500.00, 600.00),
(15, 'I', 1500.00, 1500.00, 500.00, 100.00),
(16, 'I', 5000.00, 1500.00, 500.00, 200.00),
(17, 'I', 30000.00, 1500.00, 500.00, 1000.00),
(18, 'I', 7000.00, 1500.00, 500.00, 250.00),
(19, 'I', 12000.00, 1500.00, 500.00, 300.00),
(20, 'I', 25000.00, 1500.00, 500.00, 800.00);