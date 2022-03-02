-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblacta`
--

CREATE TABLE `tblacta` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `observaciones` varchar(255) NOT NULL,
  `responsable` varchar(100) NOT NULL,
  `proveedorID` int(11) NOT NULL,
  `empleadoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcargos`
--

CREATE TABLE `tblcargos` (
  `CargoID` int(11) NOT NULL,
  `CarNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblcargos`
--

INSERT INTO `tblcargos` (`CargoID`, `CarNombre`) VALUES
(1, 'Administrador de Bodega'),
(2, 'Auxiliar de Bodega');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcategorias`
--

CREATE TABLE `tblcategorias` (
  `CategoriaID` int(11) NOT NULL,
  `CatNombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblcategorias`
--

INSERT INTO `tblcategorias` (`CategoriaID`, `CatNombre`) VALUES
(1, 'Tablet'),
(2, 'PC Escritorio'),
(3, 'Laptop'),
(4, 'Smartphone');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetalleproducto`
--

CREATE TABLE `tbldetalleproducto` (
  `DetProID` int(11) NOT NULL,
  `DetProCantidad` int(11) NOT NULL,
  `DetProFechaRegistro` date NOT NULL,
  `TblProveedores_ProveedorID` int(11) DEFAULT NULL,
  `TblProductos_ProductoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblempleados`
--

CREATE TABLE `tblempleados` (
  `EmpleadoID` int(11) NOT NULL,
  `EmpIdentificacion` int(11) NOT NULL,
  `EmpNombre` varchar(50) NOT NULL,
  `EmpApellido` varchar(50) NOT NULL,
  `TblGeneros_GeneroID` int(11) DEFAULT NULL,
  `TblCargos_CargoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblempleados`
--

INSERT INTO `tblempleados` (`EmpleadoID`, `EmpIdentificacion`, `EmpNombre`, `EmpApellido`, `TblGeneros_GeneroID`, `TblCargos_CargoID`) VALUES
(9, 123, 'GUILLERMO', 'LUNA', 2, 2),
(10, 111, 'FABIAN', 'BELTRÁN', 2, 2),
(11, 123456, 'RAMIRO', 'CORDOVA', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblgeneros`
--

CREATE TABLE `tblgeneros` (
  `GeneroID` int(11) NOT NULL,
  `GenNombre` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblgeneros`
--

INSERT INTO `tblgeneros` (`GeneroID`, `GenNombre`) VALUES
(1, 'Femenino'),
(2, 'Masculino'),
(3, 'Otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproductos`
--

CREATE TABLE `tblproductos` (
  `ProductoID` int(11) NOT NULL,
  `ProCodigo` varchar(20) NOT NULL,
  `ProNombre` varchar(20) NOT NULL,
  `ProSerial` varchar(50) NOT NULL,
  `ProEstado` varchar(5) NOT NULL,
  `TblCategorias_CategoriaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblproductos`
--

INSERT INTO `tblproductos` (`ProductoID`, `ProCodigo`, `ProNombre`, `ProSerial`, `ProEstado`, `TblCategorias_CategoriaID`) VALUES
(30, '001', 'Computador Dell', 'XAR123', 'Nuevo', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproveedores`
--

CREATE TABLE `tblproveedores` (
  `ProveedorID` int(11) NOT NULL,
  `ProNIT` varchar(20) NOT NULL,
  `ProNombre` varchar(80) NOT NULL,
  `ProTelefono` varchar(20) DEFAULT NULL,
  `ProDireccion` varchar(150) DEFAULT NULL,
  `ProEmail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblproveedores`
--

INSERT INTO `tblproveedores` (`ProveedorID`, `ProNIT`, `ProNombre`, `ProTelefono`, `ProDireccion`, `ProEmail`) VALUES
(3, '88282', 'COMFAMILIAR DE NARIÑO', '72020', 'Calle 15 # 14 15', 'comfamiliar@gmail.com'),
(4, '8003154548', 'CASINO CARNAVAL', '72020', 'Unicentro', 'casinocarnavalpasto@gmail.com'),
(5, '123', 'CATANA SAS', '75154', 'Av. 14 # 54 b 47', 'catana@gmail.com'),
(6, '124', 'COMPENSAR', '12132', 'Av. 45 # 45 - 78', 'compensarsas@hotmail.com'),
(7, '1515', 'MERCABODEGA', '123', 'Cra 44 - 45 - 78', 'mercabodega@outlook.es'),
(8, '12345', 'PROVEEDOR PRUEBA', '72020', 'CENTRO', 'prueba@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblroles`
--

CREATE TABLE `tblroles` (
  `IdRol` int(11) NOT NULL,
  `RolNombre` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblroles`
--

INSERT INTO `tblroles` (`IdRol`, `RolNombre`) VALUES
(3, 'Administrador'),
(4, 'Auxiliar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuarios`
--

CREATE TABLE `tblusuarios` (
  `UsuarioID` int(11) NOT NULL,
  `UsuNombre` varchar(20) NOT NULL,
  `UsuClave` varchar(255) NOT NULL,
  `TblRoles_IdRol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblusuarios`
--

INSERT INTO `tblusuarios` (`UsuarioID`, `UsuNombre`, `UsuClave`, `TblRoles_IdRol`) VALUES
(4, 'auxcomp', 'XNniVhA+JIg=', 4),
(5, 'admincomp', 'NAmh3z1X//8=', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblacta`
--
ALTER TABLE `tblacta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `proveedorID` (`proveedorID`),
  ADD KEY `empleadoID` (`empleadoID`);

--
-- Indices de la tabla `tblcargos`
--
ALTER TABLE `tblcargos`
  ADD PRIMARY KEY (`CargoID`);

--
-- Indices de la tabla `tblcategorias`
--
ALTER TABLE `tblcategorias`
  ADD PRIMARY KEY (`CategoriaID`);

--
-- Indices de la tabla `tbldetalleproducto`
--
ALTER TABLE `tbldetalleproducto`
  ADD PRIMARY KEY (`DetProID`),
  ADD KEY `tbldetalleproducto_ibfk_1` (`TblProductos_ProductoID`),
  ADD KEY `tbldetalleproducto_ibfk_2` (`TblProveedores_ProveedorID`);

--
-- Indices de la tabla `tblempleados`
--
ALTER TABLE `tblempleados`
  ADD PRIMARY KEY (`EmpleadoID`),
  ADD UNIQUE KEY `EmpIdentificacion` (`EmpIdentificacion`),
  ADD UNIQUE KEY `EmpIdentificacion_2` (`EmpIdentificacion`),
  ADD KEY `TblCargos_CargoID` (`TblCargos_CargoID`),
  ADD KEY `TblGeneros_GeneroID` (`TblGeneros_GeneroID`);

--
-- Indices de la tabla `tblgeneros`
--
ALTER TABLE `tblgeneros`
  ADD PRIMARY KEY (`GeneroID`);

--
-- Indices de la tabla `tblproductos`
--
ALTER TABLE `tblproductos`
  ADD PRIMARY KEY (`ProductoID`),
  ADD UNIQUE KEY `ProCodigo` (`ProCodigo`),
  ADD KEY `TblCategorias_CategoriaID` (`TblCategorias_CategoriaID`);

--
-- Indices de la tabla `tblproveedores`
--
ALTER TABLE `tblproveedores`
  ADD PRIMARY KEY (`ProveedorID`),
  ADD UNIQUE KEY `ProNIT` (`ProNIT`);

--
-- Indices de la tabla `tblroles`
--
ALTER TABLE `tblroles`
  ADD PRIMARY KEY (`IdRol`);

--
-- Indices de la tabla `tblusuarios`
--
ALTER TABLE `tblusuarios`
  ADD PRIMARY KEY (`UsuarioID`),
  ADD UNIQUE KEY `UsuNombre` (`UsuNombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblacta`
--
ALTER TABLE `tblacta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tblcargos`
--
ALTER TABLE `tblcargos`
  MODIFY `CargoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tblcategorias`
--
ALTER TABLE `tblcategorias`
  MODIFY `CategoriaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tbldetalleproducto`
--
ALTER TABLE `tbldetalleproducto`
  MODIFY `DetProID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `tblempleados`
--
ALTER TABLE `tblempleados`
  MODIFY `EmpleadoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `tblgeneros`
--
ALTER TABLE `tblgeneros`
  MODIFY `GeneroID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tblproductos`
--
ALTER TABLE `tblproductos`
  MODIFY `ProductoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `tblproveedores`
--
ALTER TABLE `tblproveedores`
  MODIFY `ProveedorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tblroles`
--
ALTER TABLE `tblroles`
  MODIFY `IdRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tblusuarios`
--
ALTER TABLE `tblusuarios`
  MODIFY `UsuarioID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblacta`
--
ALTER TABLE `tblacta`
  ADD CONSTRAINT `tblacta_ibfk_1` FOREIGN KEY (`proveedorID`) REFERENCES `tblproveedores` (`ProveedorID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tblacta_ibfk_2` FOREIGN KEY (`empleadoID`) REFERENCES `tblempleados` (`EmpleadoID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbldetalleproducto`
--
ALTER TABLE `tbldetalleproducto`
  ADD CONSTRAINT `tbldetalleproducto_ibfk_1` FOREIGN KEY (`TblProductos_ProductoID`) REFERENCES `tblproductos` (`ProductoID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tbldetalleproducto_ibfk_2` FOREIGN KEY (`TblProveedores_ProveedorID`) REFERENCES `tblproveedores` (`ProveedorID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `tblempleados`
--
ALTER TABLE `tblempleados`
  ADD CONSTRAINT `tblempleados_ibfk_1` FOREIGN KEY (`TblCargos_CargoID`) REFERENCES `tblcargos` (`CargoID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `tblempleados_ibfk_2` FOREIGN KEY (`TblGeneros_GeneroID`) REFERENCES `tblgeneros` (`GeneroID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `tblproductos`
--
ALTER TABLE `tblproductos`
  ADD CONSTRAINT `tblproductos_ibfk_1` FOREIGN KEY (`TblCategorias_CategoriaID`) REFERENCES `tblcategorias` (`CategoriaID`) ON DELETE SET NULL ON UPDATE CASCADE;


DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_actaio_id` (IN `pActaID` INT)  BEGIN
    SELECT 
    act.ActaID, 
    act.ActCodigo, 
    act.ActFecha, 
    act.ActObservaciones,
    act.ActResponsableProveedor,
    pro.ProveedorID,
    pro.ProNIT,
    pro.ProNombre,
    pro.ProTelefono,
    pro.ProDireccion,
    pro.ProEmail,
    det.DetProID,
   	emp.EmpleadoID,
    emp.EmpIdentificacion,
    CONCAT(emp.EmpNombre, " ", emp.EmpApellido) AS 'Nombre Empleado'
    FROM `tblactaio` AS act
    INNER JOIN tblproveedores AS pro
    ON pro.ProveedorID=act.ActaID
    INNER JOIN tbldetalleproducto AS det
    ON det.DetProID=act.TblDetalleProducto_DetProID
    INNER JOIN tblempleados AS emp
    ON emp.EmpleadoID=act.TblEmpleados_EmpleadoID
    WHERE ActaID=pActaID;
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_cargo_id` (IN `pCargoID` INT)  BEGIN
	SELECT 
    	`CargoID`,
        `CarNombre` 
	FROM `tblcargos` 
    WHERE CargoID=pCargoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_categoria_id` (IN `pCategoriaID` INT)  BEGIN
	SELECT 
    	`CategoriaID`, 
        `CatNombre` 
	FROM `tblcategorias` 
    WHERE CategoriaID=pCategoriaID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_detalle_producto` (IN `pNit` VARCHAR(20), IN `pCodigo` VARCHAR(20), IN `pFecha` DATE)  BEGIN
	SELECT 
	det.DetProID, 
	det.DetProCantidad, 
	det.DetProFechaRegistro,
	prov.ProveedorID,
    prov.ProNombre,
	prod.ProductoID,
    prod.ProCodigo,
    prod.ProNombre AS "NombreProducto",
    prod.ProSerial,
    prod.ProEstado,
    cat.CategoriaID,
    cat.CatNombre
FROM `tbldetalleproducto` AS det
INNER JOIN tblproveedores as prov
ON prov.ProveedorID=det.TblProveedores_ProveedorID
INNER JOIN  tblproductos as prod
ON prod.ProductoID=det.TblProductos_ProductoID
INNER JOIN tblcategorias as cat
ON cat.CategoriaID=prod.TblCategorias_CategoriaID
WHERE prov.ProNIT=pNit AND prod.ProCodigo=pCodigo AND det.DetProFechaRegistro=pFecha;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_detalle_producto_todos` (IN `pNit` VARCHAR(20), IN `pFecha` DATE)  BEGIN
	SELECT 
	det.DetProID, 
	det.DetProCantidad, 
	det.DetProFechaRegistro,
	prov.ProveedorID,
    prov.ProNombre,
	prod.ProductoID,
    prod.ProCodigo,
    prod.ProNombre AS "NombreProducto",
    prod.ProSerial,
    prod.ProEstado,
    cat.CategoriaID,
    cat.CatNombre
FROM `tbldetalleproducto` AS det
INNER JOIN tblproveedores as prov
ON prov.ProveedorID=det.TblProveedores_ProveedorID
INNER JOIN  tblproductos as prod
ON prod.ProductoID=det.TblProductos_ProductoID
INNER JOIN tblcategorias as cat
ON cat.CategoriaID=prod.TblCategorias_CategoriaID
WHERE prov.ProNIT=pNit AND det.DetProFechaRegistro=pFecha;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_empleado_id` (IN `pEmpIdentificacion` INT)  BEGIN
	SELECT 
        emp.EmpleadoID, 
        emp.EmpIdentificacion, 
        emp.EmpNombre, 
        emp.EmpApellido, 
        gen.GeneroID,
        gen.GenNombre,
        car.CargoID,
        car.CarNombre
	FROM `tblempleados` AS emp
    INNER JOIN tblgeneros AS gen 
    ON gen.GeneroID=emp.TblGeneros_GeneroID
    INNER JOIN tblcargos AS car 
    ON car.CargoID=emp.TblCargos_CargoID
    WHERE emp.EmpIdentificacion=pEmpIdentificacion;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_nombre_usuario` (IN `pUsuNombre` VARCHAR(20))  BEGIN
	SELECT 
    	`UsuarioID`, 
        `UsuNombre`, 
        `UsuClave`, 
        `TblRoles_IdRol` 
     FROM `tblusuarios`
     WHERE UsuNombre=pUsuNombre;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_producto_codigo` (IN `pCodigo` VARCHAR(20))  BEGIN
	SELECT pro.ProductoID
    FROM tblproductos AS pro
    WHERE pro.ProCodigo=pCodigo;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_proveedor_nit` (IN `pProNIT` VARCHAR(20))  BEGIN
	SELECT 
    	`ProveedorID`, 
        `ProNIT`, 
        `ProNombre`, 
        `ProTelefono`, 
        `ProDireccion`,
        `ProEmail`
    FROM `tblproveedores`
    WHERE ProNIT=pProNIT;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_rol_id` (IN `pIdRol` INT)  BEGIN
	SELECT 
    	`IdRol`, 
        `RolNombre` 
	FROM `tblroles`
    WHERE IdRol=pIdRol;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_acta` (IN `pCodigo` VARCHAR(20), IN `pFecha` DATE, IN `pObservaciones` VARCHAR(255), IN `pResponsable` VARCHAR(100), IN `pProveedorID` INT, IN `pEmpleadoID` INT)  BEGIN
INSERT INTO `tblacta`(
	`codigo`,
    `fecha`, 
    `observaciones`,
    `responsable`,
    `proveedorID`,
    `empleadoID`
) VALUES (
	pCodigo,
    pFecha, 
    pObservaciones,
    pResponsable,
    pProveedorID,
    pEmpleadoID
);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_cargo` (IN `pCarNombre` VARCHAR(50))  BEGIN
INSERT INTO `tblcargos`(`CarNombre`) 
VALUES (pCarNombre);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_categoria` (IN `pCatNombre` VARCHAR(20))  BEGIN
INSERT INTO `tblcategorias`(`CatNombre`) 
VALUES (pCatNombre);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_detalle_producto` (IN `pDetProCantidad` INT, IN `pDetProFechaRegistro` DATE, IN `pTblProveedores_ProveedorID` INT, IN `pTblProductos_ProductoID` INT)  BEGIN
INSERT INTO `tbldetalleproducto`(
    `DetProCantidad`,
    `DetProFechaRegistro`, 
    `TblProveedores_ProveedorID`, 
    `TblProductos_ProductoID`
) VALUES (
	pDetProCantidad, 
    pDetProFechaRegistro, 
    pTblProveedores_ProveedorID,
    pTblProductos_ProductoID
);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_empleado` (IN `pEmpIdentificacion` INT, IN `pEmpNombre` VARCHAR(50), IN `pEmpApellido` VARCHAR(50), IN `pTblGeneros_GeneroID` INT, IN `pTblCargos_CargoID` INT)  BEGIN
INSERT INTO `tblempleados`(
    `EmpIdentificacion`,
    `EmpNombre`,
    `EmpApellido`,
    `TblGeneros_GeneroID`,
    `TblCargos_CargoID`    
) VALUES (
    pEmpIdentificacion,
    pEmpNombre,
    pEmpApellido,
    pTblGeneros_GeneroID,
    pTblCargos_CargoID
);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_producto` (IN `pProCodigo` VARCHAR(20), IN `pProNombre` VARCHAR(20), IN `pProSerial` VARCHAR(50), IN `pProEstado` VARCHAR(5), IN `pTblCategorias_CategoriaID` INT)  BEGIN
	INSERT INTO `tblproductos`(
        `ProCodigo`, 
        `ProNombre`, 
        `ProSerial`, 
        `ProEstado`,
        `TblCategorias_CategoriaID`
    ) 
    VALUES (
        pProCodigo, 
        pProNombre, 
        pProSerial, 
        pProEstado,
        pTblCategorias_CategoriaID
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_proveedor` (IN `pProNIT` VARCHAR(20), IN `pProNombre` VARCHAR(80), IN `pProTelefono` VARCHAR(20), IN `pProDireccion` VARCHAR(150), IN `pProEmail` VARCHAR(50))  BEGIN
	INSERT INTO `tblproveedores`(
    	`ProNIT`, 
    	`ProNombre`, 
    	`ProTelefono`, 
    	`ProDireccion`,
        `ProEmail`
	) VALUES (
		pProNIT, 
    	pProNombre, 
    	pProTelefono, 
    	pProDireccion,
        pProEmail
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_rol` (IN `pRolNombre` VARCHAR(15))  BEGIN
INSERT INTO `tblroles`(`RolNombre`) 
VALUES (pRolNombre);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crear_usuario` (IN `pUsuNombre` VARCHAR(20), IN `pUsuClave` VARCHAR(255), IN `pTblRoles_IdRol` INT)  BEGIN
	INSERT INTO `tblusuarios`(
        `UsuNombre`, 
        `UsuClave`, 
        `TblRoles_IdRol`
    ) VALUES (
        pUsuNombre,
        pUsuClave,
        pTblRoles_IdRol
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_actaio` (IN `pActaID` INT, IN `ActCodigo` VARCHAR(20), IN `ActFecha` DATETIME, IN `ActObservaciones` VARCHAR(255), IN `ActResponsableProveedor` VARCHAR(100), IN `TblProveedores_ProveedorID` INT, IN `TblDetalleProducto_DetProID` INT, IN `TblEmpleados_EmpleadoID` INT)  BEGIN
UPDATE `tblactaio`
SET `ActCodigo`=pActCodigo,
    `ActFecha`=pActFecha, 
    `ActObservaciones`=pActObservaciones,
    `ActResponsableProveedor`=pActResponsableProveedor,
    `TblProveedores_ProveedorID`=pTblProveedores_ProveedorID,
    `TblDetalleProducto_DetProID`=pTblDetalleProducto_DetProID, 
    `TblEmpleados_EmpleadoID`=pTblEmpleados_EmpleadoID
WHERE ActaID=pActaID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_cargo` (IN `pCargoID` INT, IN `pCarNombre` VARCHAR(50))  BEGIN
UPDATE `tblcargos` 
SET `CarNombre`=pCarNombre
WHERE CargoID=pCargoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_categoria` (IN `pCategoriaID` INT, IN `pCatNombre` VARCHAR(20))  BEGIN
    UPDATE `tblcategorias` 
    SET `CatNombre`=pCatNombre
    WHERE CategoriaID=pCategoriaID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_detalle_producto` (IN `pDetProID` INT, IN `pDetProCantidad` INT, IN `pDetProFechaRegistro` DATETIME, IN `pTblProveedores_ProveedorID` INT, IN `pTblProductos_ProductoID` INT)  BEGIN
UPDATE `tbldetalleproducto`
SET `DetProCantidad`=pDetProCantidad,
    `DetProFechaRegistro`=pDetProFechaRegistro, 
    `TblProveedores_ProveedorID`=pTblProveedores_ProveedorID, 
    `TblProductos_ProductoID`=pTblProductos_ProductoID
WHERE DetProID=pDetProID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_empleado` (IN `pEmpIdentificacion` INT, IN `pEmpNombre` VARCHAR(50), IN `pEmpApellido` VARCHAR(50), IN `pTblGeneros_GeneroID` INT, IN `pTblCargos_CargoID` INT)  BEGIN
UPDATE `tblempleados`
SET `EmpNombre`=pEmpNombre,
    `EmpApellido`=pEmpApellido,
    `TblGeneros_GeneroID`=pTblGeneros_GeneroID,
    `TblCargos_CargoID`=pTblCargos_CargoID
    WHERE EmpIdentificacion=pEmpIdentificacion;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_producto` (IN `pProductoID` INT, IN `pProCodigo` VARCHAR(20), IN `pProNombre` VARCHAR(20), IN `pProSerial` VARCHAR(50), IN `pProEstado` BOOLEAN, IN `pTblCategorias_CategoriaID` INT)  BEGIN
UPDATE `tblproductos`
SET `ProCodigo`=pProCodigo, 
    `ProNombre`=pProNombre, 
    `ProSerial`=pProSerial,
    `ProEstado`=pProEstado,
    `TblCategorias_CategoriaID`=pTblCategorias_CategoriaID
WHERE ProductoID=pProductoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_proveedor` (IN `pProveedorID` INT, IN `pProNIT` VARCHAR(20), IN `pProNombre` VARCHAR(80), IN `pProTelefono` VARCHAR(20), IN `pProDireccion` VARCHAR(150), IN `pProEmail` VARCHAR(50))  BEGIN
	UPDATE `tblproveedores`
   	SET `ProNIT`=pProNIT, 
    	`ProNombre`=pProNombre, 
    	`ProTelefono`=pProTelefono, 
    	`ProDireccion`=pProDireccion,
        `ProEmail`=pProEmail
     WHERE ProveedorID=pProveedorID;
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_rol` (IN `pIdRol` INT, IN `pRolNombre` INT(15))  BEGIN
UPDATE `tblroles`
SET `RolNombre`=pRolNombre
WHERE IdRol=pIdRol;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_usuario` (IN `pUsuarioID` INT, IN `pUsuNombre` VARCHAR(20), IN `pUsuClave` VARCHAR(255), IN `pTblRoles_IdRol` INT)  BEGIN
	UPDATE `tblusuarios`
    SET `UsuNombre`=pUsuNombre,
        `UsuClave`=pUsuClave,
        `TblRoles_IdRol`=pTblRoles_IdRol
    WHERE UsuarioID=pUsuarioID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_actaio` (IN `pActaID` INT)  BEGIN
DELETE FROM `tblactaio`
WHERE ActaID=pActaID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_cargo` (IN `pCargoID` INT)  BEGIN
DELETE FROM `tblcargos` WHERE CargoID=pCargoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_categoria` (IN `pCategoriaID` INT)  BEGIN
DELETE FROM `tblcategorias` WHERE CategoriaID=pCategoriaID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_detalle_producto` (IN `pDetProID` INT)  BEGIN
	DELETE FROM `tbldetalleproducto`
	WHERE DetProID=pDetProID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_empleado` (IN `pEmpleadoID` INT)  BEGIN
DELETE FROM `tblempleados`
WHERE EmpleadoID=pEmpleadoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_producto` (IN `pProductoID` INT)  BEGIN
	DELETE FROM `tblproductos`
    WHERE ProductoID=pProductoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_proveedor` (IN `pProveedorID` INT)  BEGIN
	DELETE FROM `tblproveedores`
    WHERE ProveedorID=pProveedorID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_rol` (IN `pIdRol` INT)  BEGIN
	DELETE FROM `tblroles`
	WHERE IdRol=pIdRol;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_usuario` (IN `pUsuarioID` INT)  BEGIN
	DELETE FROM `tblusuarios`
	WHERE UsuarioID=pUsuarioID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_actaio` ()  BEGIN
    SELECT 
    act.ActaID, 
    act.ActCodigo, 
    act.ActFecha, 
    act.ActObservaciones,
    act.ActResponsableProveedor,
    pro.ProveedorID,
    pro.ProNIT,
    pro.ProNombre,
    pro.ProTelefono,
    pro.ProDireccion,
    det.DetProID,
   	emp.EmpleadoID,
    emp.EmpIdentificacion,
    CONCAT(emp.EmpNombre, " ", emp.EmpApellido) AS 'Nombre Empleado'
    FROM `tblactaio` AS act
    INNER JOIN tblproveedores AS pro
    ON pro.ProveedorID=act.ActaID
    INNER JOIN tbldetalleproducto AS det
    ON det.DetProID=act.TblDetalleProducto_DetProID
    INNER JOIN tblempleados AS emp
    ON emp.EmpleadoID=act.TblEmpleados_EmpleadoID;
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_cargos` ()  BEGIN
	SELECT 
    	`CargoID`, 
        `CarNombre` 
	FROM `tblcargos`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_categorias` ()  BEGIN 
	SELECT 
        `CategoriaID`, 
        `CatNombre`  
	FROM `tblcategorias`; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_empleados` ()  BEGIN
	SELECT 
        emp.EmpleadoID, 
        emp.EmpIdentificacion, 
        emp.EmpNombre, 
        emp.EmpApellido, 
        gen.GeneroID,
        gen.GenNombre,
        car.CargoID,
        car.CarNombre
	FROM `tblempleados` AS emp
    INNER JOIN tblgeneros AS gen 
    ON gen.GeneroID=emp.TblGeneros_GeneroID
    INNER JOIN tblcargos AS car 
    ON car.CargoID=emp.TblCargos_CargoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_generos` ()  BEGIN
	SELECT 
    	`GeneroID`, 
        `GenNombre` 
    FROM `tblgeneros`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_productos` ()  SELECT 
		pro.ProductoID, 
    	pro.ProCodigo, 
    	pro.ProNombre, 
    	pro.ProSerial,
        pro.ProEstado,
        cat.CategoriaID,
    	cat.CatNombre
FROM `tblproductos` AS pro
INNER JOIN tblcategorias AS cat ON cat.CategoriaID=pro.TblCategorias_CategoriaID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_proveedores` ()  BEGIN
	SELECT 
    	`ProveedorID`, 
        `ProNIT`, 
        `ProNombre`, 
        `ProTelefono`, 
        `ProDireccion`,
        `ProEmail`
    FROM `tblproveedores`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_roles` ()  BEGIN
	SELECT 
    	`IdRol`, 
        `RolNombre` 
	FROM `tblroles`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_usuarios` ()  BEGIN
	SELECT 
    	`UsuarioID`, 
        `UsuNombre`, 
        `UsuClave`, 
        `TblRoles_IdRol` 
     FROM `tblusuarios`;
END$$

DELIMITER ;
