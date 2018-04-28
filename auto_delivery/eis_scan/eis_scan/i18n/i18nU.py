# encoding: utf-8
'''
Created on 2014-9-10

@author: Administrator
'''
import os
from config import config

import sys

if sys.getdefaultencoding() != 'utf-8':
    reload(sys)
    sys.setdefaultencoding('utf-8')
projPath = config.rootPath
# i18nToolsPath = "C:/Python27/Tools/i18n/"
i18nToolsPath = os.path.join(config.rootPath, "i18n/")
localedir = config.rootPath + '/i18n'
from libs import web
import gettext
import copy
import json
# Object used to store all translations.
allTranslations = web.storage()

def get_translations(lang='zh_CN'):
    # Init translation.
    if allTranslations.has_key(lang):
        translation = allTranslations[lang]
    elif lang is None:
        translation = gettext.NullTranslations()
    else:
        try:
            translation = gettext.translation(
                    'messages',
                    localedir,
                    languages=[lang],
                    )
        except IOError:
            translation = gettext.NullTranslations()
    return translation

def load_translations(lang):
    """Return the translations for the locale."""
    lang = str(lang)
    translation = allTranslations.get(lang)
    if translation is None:
        translation = get_translations(lang)
        allTranslations[lang] = translation

        # Delete unused translations.
        for lk in allTranslations.keys():
            if lk != lang:
                del allTranslations[lk]
    return translation

def _(string):
    """Translate a given string to the language of the application."""
    string = unicode(string)
    lang = "zh_CN"
    if web.config and hasattr(web.config, '_session') and web.config._session and hasattr(web.config._session, 'lang'):
        lang = web.config._session.get('lang')
    translation = load_translations(lang)
    if translation is None:
        return string
    return translation.ugettext(string)
def getI18nMap(lang=None):
    if not lang:
        lang = web.config._session.get('lang', 'zh_CN')
    d = copy.deepcopy(load_translations(lang)._catalog)
    d.pop("")
    rtn = json.dumps(d)
    return rtn
'''
如果要扫描指定目录下的文件，包括子目录，需要调用scan_files("/export/home/test/")
如果要扫描指定目录下的特定后缀的文件（比如jar包），包括子目录，调用scan_files("/export/home/test/", postfix=".jar")
如果要扫描指定目录下的特定前缀的文件（比如test_xxx.py），包括子目录，调用scan_files("/export/home/test/", prefix="test_")
'''
def scan_files(directory,prefix=None,postfix=None,exclude=None):
    files_list=[]
    for root, sub_dirs, files in os.walk(directory):
        for special_file in files:
            if exclude and special_file in exclude:
                continue
            if postfix:
                if special_file.endswith(postfix):
                    files_list.append(os.path.join(root,special_file))
            elif prefix:
                if special_file.startswith(prefix):
                    files_list.append(os.path.join(root,special_file))
            else:
                files_list.append(os.path.join(root,special_file))
    return files_list
def scan_dirs(directory,prefix=None,postfix=None,exclude=None):
    dirs_list=[]
    for root, sub_dirs, files in os.walk(directory):
        for special_dir in sub_dirs:
            if exclude and special_dir in exclude:
                continue
            if postfix:
                if special_dir.endswith(postfix):
                    dirs_list.append(os.path.join(root,special_dir))
            elif prefix:
                if special_dir.startswith(prefix):
                    dirs_list.append(os.path.join(root,special_dir))
            else:
                dirs_list.append(os.path.join(root,special_dir))
    return dirs_list
def generatePo():
    pyFiles = []
    pyRootPaths = [
            "config",
            "controllers",
            "libs/ocr",
            "model",
            "service",
            "tools",
            ]
    
    for pyRootPath in pyRootPaths: 
        pyFiles.append(os.path.join(projPath,pyRootPath,"*.py"))
        #添加子目录
        for dirPy in scan_dirs(os.path.join(projPath,pyRootPath)):
            pyFiles.append(os.path.join(dirPy,"*.py"))
    htmlFiles = scan_files(projPath,postfix=".html",exclude=["main.html"])
    jsFiles = scan_files(projPath,postfix=".js",exclude=["jquery-1.11.1.min.js"])
    files =[]
    files.extend(pyFiles)
    files.extend(htmlFiles)
    files.extend(jsFiles)
    if len(files)<1:
        return
    os.system('python ' + i18nToolsPath + 'pygettext.py -a -v -d messages -o ' + projPath + 'i18n/messages.pot ' + " ".join(files))
#     os.system('python ' + i18nToolsPath + 'pygettext.py -a -v -d messages -o ' + projPath + (" " + projPath).join(listPath))
def mergePo():
    i18nDir = os.path.join(projPath, "i18n")
    sourceFile = os.path.join(i18nDir, "messages.pot") 
    sf = open(sourceFile)
    lines = sf.readlines()
    for lang in os.listdir(i18nDir): 
        i18nLangDir = os.path.join(i18nDir, lang) 
        if os.path.isdir(i18nLangDir): 
            print lang
            translation = load_translations(lang)
            old =  copy.deepcopy(translation._catalog) if hasattr(translation, "_catalog") else {}
            if "" in old.keys():
                old.pop("")
            targetDir = os.path.join(i18nDir, i18nLangDir, "LC_MESSAGES") 
            if not os.path.exists(targetDir): 
                os.makedirs(targetDir) 
                print "创建目录成功  ", targetDir
            targetFile = os.path.join(targetDir, "messages.po") 
            f = open(targetFile, "w") 
            index = 0
            lineCount = len(lines)
            while index < lineCount:
                line = lines[index]
                f.write(line)
                if line and line.startswith("msgid \""):
                    key = line[line.find("msgid \"")+len("msgid \""):line.rfind("\"")]
                    if old.get(unicode(key)):
                        f.write("msgstr \"%s\"\n"%old.get(unicode(key)))
                        index = index+1
                index = index+1
def copyPo(): 
    i18nDir = os.path.join(projPath, "i18n")
    for tempDir in os.listdir(i18nDir): 
        i18nLangDir = os.path.join(i18nDir, tempDir) 
        if os.path.isdir(i18nLangDir): 
            sourceFile = os.path.join(i18nDir, "messages.pot") 
            targetDir = os.path.join(i18nDir, i18nLangDir, "LC_MESSAGES") 
            if not os.path.exists(targetDir): 
                os.makedirs(targetDir) 
                print "创建目录成功  ", targetDir
            targetFile = os.path.join(targetDir, "messages.po") 
            if not os.path.exists(targetFile) or(os.path.exists(targetFile) and (os.path.getsize(targetFile) != os.path.getsize(sourceFile))): 
                open(targetFile, "wb").write(open(sourceFile, "rb").read()) 
                print "拷贝文件 成功", targetFile
def generateMo():
    i18nDir = os.path.join(projPath, "i18n")
    for tempDir in os.listdir(i18nDir):
        if os.path.isfile(os.path.join(i18nDir, tempDir)):
            continue
        moFile = os.path.join(i18nDir, tempDir, "LC_MESSAGES", "messages.mo") 
        poFile = os.path.join(i18nDir, tempDir, "LC_MESSAGES", "messages.po") 
        print poFile, os.path.isfile(poFile)
        if os.path.isfile(poFile):
            cmd = i18nToolsPath + 'msgfmt.py -o ' + moFile + " " + poFile
            print cmd
            os.system(cmd)
def main():
    generateMo()  # 生成mo文件
    generatePo()  # 生成pot文件
    mergePo()     # 合并po文件
    generateMo()  # 生成mo文件
    pass
if __name__ == '__main__':
    main()
#     lang = "en_US"
#     key = "张业勇"
#     d = load_translations(lang)._catalog
#     print d.get(key)
#     key = unicode(key)
#     print d.get(key)
    pass
