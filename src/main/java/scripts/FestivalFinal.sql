CREATE DATABASE IF NOT EXISTS festival_logistics;
USE festival_logistics;

-- 2. Tabla de Usuarios (Para el Login y Spring Security)
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Aquí irá el hash de BCrypt, por eso es largo
    rol VARCHAR(20) NOT NULL -- Ej: 'ADMIN', 'STAGE_MANAGER'
);

-- 3. Tabla de Artistas
CREATE TABLE artistas (
    id_artista INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero_musical VARCHAR(50),
    rider_tecnico TEXT -- Requerimientos del artista (ej: "3 CDJs, 2 Monitores")
);

-- 4. Tabla de Escenarios
CREATE TABLE escenarios (
    id_escenario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Ej: 'Mainstage', 'Techno Tent'
    capacidad INT NOT NULL
);

-- 5. Tabla de Equipos Logísticos (Inventario)
CREATE TABLE equipos (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL, -- Ej: 'Luces', 'Sonido', 'Efectos FX'
    descripcion VARCHAR(150) NOT NULL,
    cantidad_disponible INT NOT NULL
);

-- 6. Tabla de Presentaciones (El "Corazón" del sistema que une todo)
CREATE TABLE presentaciones (
    id_presentacion INT AUTO_INCREMENT PRIMARY KEY,
    id_artista INT NOT NULL,
    id_escenario INT NOT NULL,
    fecha_presentacion DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    
    -- Relaciones (Llaves Foráneas)
    CONSTRAINT fk_artista FOREIGN KEY (id_artista) REFERENCES artistas(id_artista),
    CONSTRAINT fk_escenario FOREIGN KEY (id_escenario) REFERENCES escenarios(id_escenario)
);


-- Insertar con un hash válido (generado con BCrypt para 'admin123')
INSERT INTO usuarios (username, password, rol) 
VALUES ('admin', '$2a$10$ZPyvrylQuNfDU4.FJoUBiu88hFl7J9WSztE480hzl40w5KzCFxbq6', 'ADMIN');

INSERT INTO artistas (nombre, genero_musical, rider_tecnico) VALUES 
('Neon Voyager', 'TECHNO', '4 CDJs, 2 Monitores, Mesa de mezclas'),
('Synthetic Dreams', 'HOUSE', '2 CDJs, 1 Mixer, Micrófono inalámbrico'),
('Data Stream', 'TRANCE', '3 CDJs, 2 Pantallas LED, Sintetizador'),
('Pulse Generator', 'HARD TECHNO', '4 CDJs, 2 Subwoofers, Efectos FX'),
('Cyber Frequency', 'EXPERIMENTAL', '2 CDJs, 1 Controlador MIDI, Vocoder'),
('Neural Link', 'AMBIENT', '2 CDJs, 1 Mezclador, Máquina de humo'),
('Kinetic Flow', 'DNB', '3 CDJs, 2 Monitores, Batería electrónica'),
('Signal Noise', 'GLITCH', '2 CDJs, 1 Mixer, Sintetizador modular');



INSERT INTO equipos (tipo, descripcion, cantidad_disponible) VALUES 
('SONIDO', 'Line Array JBL VTX A8 - Sistema principal', 12),
('SONIDO', 'Subwoofer JBL VTX S25 - Graves', 8),
('SONIDO', 'Monitor de escenario d&b M4', 15),
('LUCES', 'Cabezas móviles Martin MAC Aura PXL', 20),
('LUCES', 'Barras LED RGBW 18W x 18', 35),
('LUCES', 'Láser RGB Full Color 30W', 6),
('EFECTOS', 'Máquina de humo DJ Power Fog 3000W', 4),
('EFECTOS', 'Máquina de CO2 Jet Stream', 3),
('EFECTOS', 'Confetti Canon Pro', 8);



INSERT INTO escenarios (nombre, capacidad) VALUES 
('Mainstage - Omega Phase', 50000),
('Techno Tent - Void Core', 15000),
('House Stage - Pulse Reactor', 12000),
('Hard Techno - The Foundry', 10000),
('Experimental - Lab 01', 5000),
('Ambient - Silent Zone', 3000),
('DNB - Turbine', 8000),
('Glitch - Circuit Break', 4000);


-- Primero asegúrate de tener artistas y escenarios
INSERT INTO presentaciones (id_artista, id_escenario, fecha_presentacion, hora_inicio, hora_fin)
VALUES 
(2, 2, '2024-12-20', '20:00:00', '21:30:00'),
(4, 4, '2024-12-20', '21:30:00', '23:00:00');


INSERT INTO artistas (nombre, genero_musical, rider_tecnico) VALUES 
('Neon Voyager', 'TECHNO', '4 CDJs, 2 Monitores, Mesa de mezclas'),
('Synthetic Dreams', 'HOUSE', '2 CDJs, 1 Mixer, Micrófono inalámbrico'),
('Data Stream', 'TRANCE', '3 CDJs, 2 Pantallas LED, Sintetizador'),
('Pulse Generator', 'HARD TECHNO', '4 CDJs, 2 Subwoofers, Efectos FX'),
('Cyber Frequency', 'EXPERIMENTAL', '2 CDJs, 1 Controlador MIDI, Vocoder'),
('Neural Link', 'AMBIENT', '2 CDJs, 1 Mezclador, Máquina de humo'),
('Kinetic Flow', 'DNB', '3 CDJs, 2 Monitores, Batería electrónica'),
('Signal Noise', 'GLITCH', '2 CDJs, 1 Mixer, Sintetizador modular'),
('Leon Kennedy', 'TECHNO', '4 CDJs, 2 Monitores'),
('Migue', 'Regetoon', 'mesa'),
('DJ Test', 'TECHNO', '2 CDJs, 1 Mixer'),
('House Master', 'HOUSE', 'CDJs, Micrófono'),
('Trance Wizard', 'TRANCE', '3 CDJs, Sintetizador'),
('Hard Core', 'HARD TECHNO', 'Subwoofers, FX'),
('Experimental Lab', 'EXPERIMENTAL', 'MIDI, Vocoder');


SELECT * FROM artistas;