@echo off 
echo √√    √√  √√√      √√√√  √√√√√    √√√√
echo   √    √  √      √  √      √  √  √  √  √      √
echo   √    √  √      √  √              √      √
echo   √√√√  √      √    √√          √        √√
echo   √    √  √      √        √        √            √
echo   √    √  √      √          √      √              √
echo   √    √  √      √  √      √      √      √      √
echo √√    √√  √√√    √√√√      √√√    √√√√
echo ----------------------------------------------------------- 
echo  老D博客 LAOD.CN  LAOD.ORG  LAOD.TOP
echo  2016 永久更新地址：
echo  http://laod.cn/hosts/2016-google-hosts.html
echo -----------------------------------------------------------
copy "%~dp0hosts" "%SystemRoot%\System32\drivers\etc\hosts"
ipconfig /flushdns
pause