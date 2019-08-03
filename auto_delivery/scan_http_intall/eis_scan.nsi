; example2.nsi
;
; This script is based on example1.nsi, but it remember the directory,
; has uninstall support and (optionally) installs start menu shortcuts.
;
; It will install example2.nsi into a directory that the user selects,

;--------------------------------

; The name of the installer
Name "影像扫描系统"

; The file to write
OutFile "self_scan_setup.exe"

; The default installation directory
InstallDir D:\self_scan

; Request application privileges for Windows Vista
RequestExecutionLevel admin

;--------------------------------

; Pages

Page components
Page directory
Page instfiles

UninstPage uninstConfirm
UninstPage instfiles

;--------------------------------

; The stuff to install
Section "自助扫描系统 (required)"

  SectionIn RO

  ; Set output path to the installation directory.
  SetOutPath $INSTDIR

  ; Put file there
  File "index.html"
  File "scan.bat"
  File "cfg.ini"
  File "debug.bat"
  File "client.bat"
  File "startup.exe"
  File /r /x "*.py" "..\eis_scan_http\eis_scan"
  File /r /x "*.py" "..\eis_scan_http\scanClient"
  File /r "..\Python27"


  WriteUninstaller "$INSTDIR\uninstall.exe"
SectionEnd

; Optional section (can be disabled by the user)
Section "创建快捷方式"

  CreateDirectory "$SMPROGRAMS\自助扫描系统"
  CreateShortcut "$SMPROGRAMS\自助扫描系统\Uninstall.lnk" "$INSTDIR\uninstall.exe" "" "$INSTDIR\uninstall.exe" 0
  CreateShortcut "$SMPROGRAMS\自助扫描系统\启动.lnk" "$INSTDIR\startup.exe" "" "$INSTDIR\startup.exe" 0
  CreateShortCut "$DESKTOP\自助扫描系统.lnk" "$INSTDIR\startup.exe"


SectionEnd

;--------------------------------

; Uninstaller
Section "Uninstall"

  ; Remove files and uninstaller
  nsExec::Exec "cmd /c taskkill /f /im python.exe"
  nsExec::Exec "cmd /c taskkill /f /im startup.exe"
  RMDir /r "$INSTDIR\web_ui"
  RMDir /r "$INSTDIR\twain_client"
  RMDir /r "$INSTDIR\Python27"
  Delete "$INSTDIR\debug.bat"
  Delete "$INSTDIR\client.bat"
  Delete "$INSTDIR\index.html"
  Delete "$INSTDIR\scan.bat"
  Delete "$INSTDIR\startup.exe"
  Delete "$INSTDIR\cfg.ini"
  Delete "$INSTDIR\uninstall.exe"

  ; Remove shortcuts, if any Remove directories used
  RMDir /r "$SMPROGRAMS\自助扫描系统"
  Delete "$DESKTOP\自助扫描系统.lnk"
  RMDir "$INSTDIR"
SectionEnd
