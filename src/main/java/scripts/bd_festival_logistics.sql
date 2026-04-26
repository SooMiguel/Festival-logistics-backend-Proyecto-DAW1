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

-- 7.  Usuario administrador de prueba
-- La contraseña original es 'admin123', pero aquí está encriptada con BCrypt
INSERT INTO usuarios (username, password, rol) 
VALUES ('admin', '$2a$10$DowzG0K6nZ/P8L/lJ.2n.eJ1.2w.B/7.2G/8.2.2.2.2.2.2.2.2', 'ADMIN');