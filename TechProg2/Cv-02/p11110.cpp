#include <iostream>
#include <sstream>

using namespace std;

int main() {
    stringstream loader;
    string line;

    while (getline(cin, line)) {
        if (line.empty()) {
            return 0;
        }

        cout << line << endl;
    }
}
