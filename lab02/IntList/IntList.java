package IntList;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** Method to return a string representation of an IntList */
    public String toString() {
        if (rest == null) {
            // Converts an Integer to a String!
            return String.valueOf(first);
        } else {
            return first + " -> " + rest.toString();
        }
    }

    /**
     * Method to create an IntList from an argument list.
     * You don't have to understand this code. We have it here
     * because it's convenient with testing. It's used like this:
     *
     * IntList myList = IntList.of(1, 2, 3, 4, 5);
     * will create an IntList 1 -> 2 -> 3 -> 4 -> 5 -> null.
     *
     * You can pass in any number of arguments to IntList.of and it will work:
     * IntList mySmallerList = IntList.of(1, 4, 9);
     */
    public static IntList of(int ...argList) {
        if (argList.length == 0)
            return null;
        int[] restList = new int[argList.length - 1];
        System.arraycopy(argList, 1, restList, 0, argList.length - 1);
        return new IntList(argList[0], IntList.of(restList));
    }

    public static void dSquareList(IntList L) {
        IntList p = L;
        while (p != null) {
            p.first = p.first * p.first;
            p = p.rest;
        }
    }

    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList t = new IntList(L.first * L.first, null);;
        IntList ptr = t;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return t;
    }

    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }

        IntList R = new IntList(L.first* L.first, null);;
        IntList ptr = R;
        helper(L.rest, ptr);
        return R;
    }

    private static void helper(IntList L, IntList ptr) {
        if (L == null) {
            return;
        } else {
            ptr.rest = new IntList(L.first* L.first, null);
            helper(L.rest, ptr.rest);
        }
    }

    public static void dcatenate(IntList A, IntList B) {
        IntList ptr_a = A;
        while (ptr_a.rest != null) {
            ptr_a = ptr_a.rest;
        }
        ptr_a.rest = B;
    }

    public static IntList catenate(IntList A, IntList B) {
        IntList res = deepcopy(A);
        IntList ptr_res = res;

        while (ptr_res.rest != null) {
            ptr_res = ptr_res.rest;
        }
        ptr_res.rest = deepcopy(B);
        return res;
    }

    public static IntList deepcopy(IntList A) {
        if (A == null) {
            return null;
        }

        IntList res = new IntList(A.first, null);
        IntList ptr_a = A.rest;
        IntList ptr_res = res;

        while (ptr_a != null) {
            ptr_res.rest = new IntList(ptr_a.first, null);
            ptr_a = ptr_a.rest;
            ptr_res = ptr_res.rest;
        }
        return res;
    }
}
