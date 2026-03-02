public class Vector {
    private double[] components;

    public Vector(double[] components) {
        if (components == null || (components.length != 2 && components.length != 3)) {
            throw new IllegalArgumentException("Vector must have 2 or 3 components.");
        }
        this.components = components.length == 2 ? new double[2] : new double[3];
        System.arraycopy(components, 0, this.components, 0, this.components.length);
    }

    private void checkDimension(Vector other) throws VectorException {
        if (this.components.length != other.components.length) {
            throw new VectorException("Vectors must have the same dimension for Operation to be performed.");
        }
    }

    public Vector add(Vector other) throws VectorException {
        checkDimension(other);
        double[] result = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            result[i] = this.components[i] + other.components[i];
        }
        return new Vector(result);
    }

    public Vector subtract(Vector other) throws VectorException {
        checkDimension(other);
        double[] result = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            result[i] = this.components[i] - other.components[i];
        }
        return new Vector(result);
    }

    public double dot(Vector other) throws VectorException {
        checkDimension(other);
        double result = 0;
        for (int i = 0; i < this.components.length; i++) {
            result += this.components[i] * other.components[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < components.length; i++) {
            sb.append(components[i]);
            if (i < components.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");  
        return sb.toString();
    }
}