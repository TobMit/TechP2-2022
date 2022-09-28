#include <iostream>
#include <sstream>
#include <vector>
#include <map>
#include <set>
#include <queue>

using namespace std;

void naplnVector (string line, vector<string>&);
void naplnMap(string line, map<string, set<string>* >&);


void spracujVystup(vector<string>& vector1, map<string, set<string> *>& map1);


bool rekurzia(string basicString, queue<string> vstup, set<string> used, map<string, set<string> *> &map, int depth,
              bool firtRun, set<string> *vystup);

bool checkCharakter(string testCharakter, set<string> used, map<string, set<string> *> &map);

int main() {
    stringstream loader;
    string line;
    string delimiter = " ";

    while (getline(cin, line)) {
        vector<string> allChar;
        map<string, set<string>* > ruleMap;
        if (line.empty()) {
            return 0;
        }
        naplnVector(line, allChar);
        getline(cin, line);
        naplnMap(line, ruleMap);
        //spracujVystup(allChar, ruleMap);

        for (auto item: ruleMap) {
            delete item.second;
        }
    }

    for (auto item: ruleMap) {
        delete item.second;
    }

    return 0;

}

void spracujVystup(vector<string>& vector1, map<string, set<string> *>& map1) {
    set<string> vystup;
    set<string> used;

    for (auto item: vector1) {
        queue<string> vstup;
        for (auto itemq: vector1) {
            if (itemq.compare(item) == 0) {
                continue;
            }
            vstup.push(itemq);
        }
        rekurzia(item, vstup, used, map1, 0, true, &vystup);
    }

    for (auto item :vystup) {
        if (item.size() == vector1.size()) {
            cout << item << endl;
        }
    }
}

//retrun false ak sme sa v tomto rane nedostal k úspešnému koncu ak áno tak
bool rekurzia(string basicString, queue<string> vstup, set<string> used, map<string, set<string> *> &map, int depth,
              bool firtRun, set<string> *vystup) {
    if (depth == vstup.size() + used.size()) {
        vystup->insert(basicString);
        return true;
    }
    // ak sa vstupné dáta minuly a nie sme na 4 úrovni
    if (vstup.empty()) {
        return false;
    }

    // rieši prvý charakter pred rekurziou (ten dostávame pri prvom volaní)
    string testCharakter;
    if (firtRun) {
        testCharakter = basicString;
        basicString = "";
    } else {
        testCharakter = vstup.front();
        vstup.pop();
    }


    depth += 1;
    // či máme správny charakter na vkladanie
    if ( checkCharakter(testCharakter, used, map)) {
        //môžeme pokračovať na novú úroveň
        int i = 0;
        do {
            i++;
            set<string> usedNew = used;
            usedNew.insert(testCharakter);
            rekurzia(basicString + testCharakter, vstup, usedNew, map, depth, false, vystup);
            // posunieme vstup pre dalšie testovanie aby sme otestovali všetky možnosti
            string tmpVstup = vstup.front();
            vstup.pop();
            vstup.push(tmpVstup);
        } while (i < vstup.size());
        return true;

    } else {
        // ak nie tak končíme v tejto branči
        return false;
    }

}

/**
 * funkcia testuje či mám správny charakter
 * @param testCharakter
 * @param used
 * @param map
 * @return
 */
bool checkCharakter(string testCharakter, set<string> used, map<string, set<string> *> &map) {
    bool platne = true;
    //kontrolujem či sa v databáze pravidiel nachádza taký znak
    if (map.contains(testCharakter)) {
        auto testVector = map.find(testCharakter)->second;
        // ak áno tak testujem či mám dobrý vector
        if (testVector != nullptr) {
            //prechádzam celý vektor
            for (auto overenie: *testVector) {
                // ak sme zatiaľ nepoužili žiaden charakter tak všetky sú správne
                if (used.empty()) {
                    break;
                }
                // ak sme použili nejaký charakter ktorý sa mal nachádzať až po tomto tak je to neplatné
                if (used.contains(overenie)) {
                    platne = false;
                }
            }
        }
    }

    return platne;
}

/*
void rekurzia(string basicString, queue<string> vstup, set<string> used, map<string, set<string> *> &map, int depth,
              bool firtRun, set<string> *vystup) {
    if (depth == 4 || vstup.empty()) {
        vystup->insert(basicString);
        return;
    }

    string testCharakter;
    if (firtRun) {
        testCharakter = basicString;
        basicString = "";
    } else {
        testCharakter = vstup.front();
        vstup.pop();
    }

    bool neplatne = false;
    if (map.contains(testCharakter)) {
        auto testVector = map.find(testCharakter)->second;
        if (testVector != nullptr) {
            for (auto overenie: *testVector) {
                if (used.empty()) {
                    break;
                }
                if (used.contains(overenie)) {
                    neplatne = true;
                }
            }
        }
    }

    if (neplatne) {
        //vstup.push(testCharakter);
        return;

    }

    set<string>
    rekurzia(basicString + testCharakter, vstup, , map, depth + 1, false, vystup);



}
*/


void naplnVector(string line, vector<string>& allChar) {
    int position = 0;
    string delimiter = " ";
    while ((position = line.find(delimiter)) != string::npos) {
        string text = line.substr(0, position);
        // cout << text << endl;
        allChar.push_back(text);
        line.erase(0, position + delimiter.length());
    }
    //cout << line << endl;
    allChar.push_back(line);
}

void naplnMap(string line, map<string, set<string>* >& ruleMap) {
    int position = 0;
    string delimiter = " ";
    while ((position = line.find(delimiter)) != string::npos) {

        string character1 = line.substr(0, position);
        line.erase(0, position + delimiter.length());

        position = line.find(delimiter);
        string character2 = line.substr(0, position);
        line.erase(0, position + delimiter.length());

        if (ruleMap.contains(character1)) {
            auto arrList = ruleMap.at(character1);
            arrList->insert(character2);
        } else {
            set<string> *tmp = new set<string>;
            tmp->insert(character2);
            ruleMap.insert(pair<string, set<string>*>(character1, tmp));
        }


    }
    //cout << line << endl;


}

