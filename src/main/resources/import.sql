-- Inserir fabricantes (caso ainda não existam)
INSERT INTO fabricante (nome, pais) VALUES ('NVIDIA', 'EUA');
INSERT INTO fabricante (nome, pais) VALUES ('AMD', 'China');

-- Inserir GPUs com referência correta ao fabricante
INSERT INTO gpu (nome, id_fabricante, memoriaVRAM, tipo, arquitetura) 
VALUES ('NVIDIA GeForce RTX 3050', 1, 8, 'ENTRY_LEVEL', 'Ampere');

INSERT INTO gpu (nome, id_fabricante, memoriaVRAM, tipo, arquitetura) 
VALUES ('AMD Radeon RX 7600', 2, 8, 'MID_RANGE', 'RDNA 3');

INSERT INTO gpu (nome, id_fabricante, memoriaVRAM, tipo, arquitetura) 
VALUES ('NVIDIA GeForce RTX 4090', 1, 24, 'HIGH_END', 'Ada Lovelace');

INSERT INTO gpu (nome, id_fabricante, memoriaVRAM, tipo, arquitetura) 
VALUES ('NVIDIA Quadro RTX 6000', 1, 24, 'WORKSTATION', 'Turing');

INSERT INTO gpu (nome, id_fabricante, memoriaVRAM, tipo, arquitetura) 
VALUES ('NVIDIA A100', 1, 40, 'AI_ACCELERATOR', 'Ampere');
