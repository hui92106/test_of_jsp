@echo off 
echo �̡�    �̡�  �̡̡�      �̡̡̡�  �̡̡̡̡�    �̡̡̡�
echo   ��    ��  ��      ��  ��      ��  ��  ��  ��  ��      ��
echo   ��    ��  ��      ��  ��              ��      ��
echo   �̡̡̡�  ��      ��    �̡�          ��        �̡�
echo   ��    ��  ��      ��        ��        ��            ��
echo   ��    ��  ��      ��          ��      ��              ��
echo   ��    ��  ��      ��  ��      ��      ��      ��      ��
echo �̡�    �̡�  �̡̡�    �̡̡̡�      �̡̡�    �̡̡̡�
echo ----------------------------------------------------------- 
echo  ��D���� LAOD.CN  LAOD.ORG  LAOD.TOP
echo  2016 ���ø��µ�ַ��
echo  http://laod.cn/hosts/2016-google-hosts.html
echo -----------------------------------------------------------
copy "%~dp0hosts" "%SystemRoot%\System32\drivers\etc\hosts"
ipconfig /flushdns
pause