class taxi
{
    String name;
    int status;
    vertex location;
    vertex imminent;
    public taxi(String st,vertex ve)
    {
        name=st;
        location=ve;
        imminent=ve;
        status=0;
    }
}