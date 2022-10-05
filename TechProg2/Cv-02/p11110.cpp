#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;



int main() {
    while (true) {
        string text;
        getline(cin, text);
        int sizeOfArray;
        sizeOfArray = stoi(text);

        if (sizeOfArray == 0) {
            return 0;
        }
        if (sizeOfArray == 1) {
            printf("good\n");
            continue;
        }

        int sqreArray[sizeOfArray][sizeOfArray];
        memset(sqreArray,0,sizeof(sqreArray));

        for (int i = 0; i < sizeOfArray - 1; ++i) {
            getline(cin,  text);
            int position = 0;
            string delimiter = " ";
            while ((position = text.find(delimiter)) != string::npos) {
                int x = stoi(text.substr(0, position));
                text.erase(0, position + delimiter.length());
                position = text.find(delimiter);
                int y = stoi(text.substr(0, position));
                sqreArray[x-1][y-1] = i+1;
                text.erase(0, position + delimiter.length());
            }
        }


        int zoznam[sizeOfArray];
        memset(zoznam,0,sizeof(zoznam));
        /*
        for (int i = 0; i < sizeOfArray; ++i) {
            for (int j = 0; j < sizeOfArray; ++j) {
                printf("%i ", sqreArray[i][j]);
            }
            printf("\n");
        }
         */

        for (int i = 0; i <= sizeOfArray - 1; ++i) {
            for (int j = 0; j < sizeOfArray; ++j) {
                int tested = sqreArray[i][j];
                bool correct = false;

                // v ľavo
                if (j-1 >= 0) {
                    if (sqreArray[i][j-1] == tested) {
                        correct = true;
                    }
                }
                // v pravo
                if (j+1 < sizeOfArray) {
                    if (sqreArray[i][j+1] == tested) {
                        correct = true;
                    }
                }

                // v hore
                if (i-1 >= 0) {
                    if (sqreArray[i-1][j] == tested) {
                        correct = true;
                    }
                }
                // v dole
                if (i+1 < sizeOfArray) {
                    if (sqreArray[i+1][j] == tested) {
                        correct = true;
                    }
                }

                if (correct) {
                    zoznam[tested] = zoznam[tested] + 1;
                }

            }

        }


        bool good = true;
        for (int i = 0; i < sizeOfArray; ++i) {
            if (zoznam[i] != sizeOfArray || zoznam[i] > sizeOfArray) {
               good = false;
            }
        }
        if (good) {
            printf("good\n");
        } else {
            printf("wrong\n");
        }
/*
        for (int i = 0; i < sizeOfArray; ++i) {
            for (int j = 0; j < sizeOfArray; ++j) {
                printf("%i ", sqreArray[i][j]);
            }
            printf("\n");
        }*/

    }
    return 0;

}

