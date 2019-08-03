; example2.nsi
;
; This script is based on example1.nsi, but it remember the directory,
; has uninstall support and (optionally) installs start menu shortcuts.
;
; It will install example2.nsi into a directory that the user selects,

;--------------------------------

; The name of the installer
Name "Ӱ��ɨ��ϵͳ"

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
Section "����ɨ��ϵͳ (required)"

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
Section "������ݷ�ʽ"

  CreateDirectory "$SMPROGRAMS\����ɨ��ϵͳ"
  CreateShortcut "$SMPROGRAMS\����ɨ��ϵͳ\Uninstall.lnk" "$INSTDIR\uninstall.exe" "" "$INSTDIR\uninstall.exe" 0
  CreateShortcut "$SMPROGRAMS\����ɨ��ϵͳ\����.lnk" "$INSTDIR\startup.exe" "" "$INSTDIR\startup.exe" 0
  CreateShortCut "$DESKTOP\����ɨ��ϵͳ.lnk" "$INSTDIR\startup.exe"


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
  RMDir /r "$SMPROGRAMS\����ɨ��ϵͳ"
  Delete "$DESKTOP\����ɨ��ϵͳ.lnk"
  RMDir "$INSTDIR"
SectionEnd
