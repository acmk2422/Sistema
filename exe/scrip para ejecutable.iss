; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "Sistema Venta Tornavica"
#define MyAppVersion "1"
#define MyAppPublisher "Ing. Annig Morales"
#define MyAppExeName "SistemaVentas.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{A8CE0035-07F4-48A8-944D-0F29C4667364}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName={pf}\Sistema_Ventas_Tornavica
DisableProgramGroupPage=yes
InfoBeforeFile=C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\INSTRUCCIONESPRE.txt
InfoAfterFile=C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\INSTRUCCIONESPOST.txt
OutputDir=C:\Users\Administrador\Desktop
OutputBaseFilename=Sistema_Ventas_Tornavica
SetupIconFile=C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\icon1.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\SistemaVentas.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\configuracion exe.xml"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\icon1.ico"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\if_shopping_basket yellow_10530.ico"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\INSTRUCCIONESPOST.txt"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\INSTRUCCIONESPRE.txt"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\scrip para ejecutable.iss"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\SistemaVentas.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\exe\lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\db\*"; DestDir: "{app}\db"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\Administrador\Documents\NetBeansProjects\Sistema\src\Reportes\*"; DestDir: "{app}\Reportes"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{commonprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

