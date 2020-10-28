package org.dawnsci.janexpress;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.IntegerDataset;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.dataset.Slice;
import org.eclipse.january.dataset.Stats;

public class ExpressionMathsDelegate {

	public static Dataset pow(final Object a, final Object b) {
		return Maths.power(a, b);
	}

	public static Dataset power(final Object a, final Object b) {
		return Maths.power(a, b);
	}

	public static Dataset minimum(final Object a, final Object b) {
		return Maths.minimum(a, b);
	}

	public static Dataset maximum(final Object a, final Object b) {
		return Maths.maximum(a, b);
	}

	public static Dataset sqrt(final Object a) {
		return Maths.sqrt(a);
	}

	public static Dataset cbrt(final Object a) {
		return Maths.cbrt(a);
	}

	public static Dataset square(final Object a) {
		return Maths.square(a);
	}

	public static Dataset signum(final Object a) {
		return Maths.signum(a);
	}

	public static Dataset floor(final Object a) {
		return Maths.floor(a);
	}

	public static Dataset ceil(final Object a) {
		return Maths.ceil(a);
	}

	public static Dataset exp(final Object a) {
		return Maths.exp(a);
	}

	public static Dataset expm1(final Object a) {
		return Maths.expm1(a);
	}

	public static Dataset log(final Object a) {
		return Maths.log(a);
	}

	public static Dataset log10(final Object a) {
		return Maths.log10(a);
	}

	public static Dataset log1p(final Object a) {
		return Maths.log1p(a);
	}

	public static Dataset log2(final Object a) {
		return Maths.log2(a);
	}

	public static Dataset sin(final Object a) {
		return Maths.sin(a);
	}

	public static Dataset cos(final Object a) {
		return Maths.cos(a);
	}

	public static Dataset tan(final Object a) {
		return Maths.tan(a);
	}

	public static Dataset arcsin(final Object a) {
		return Maths.arcsin(a);
	}

	public static Dataset arccos(final Object a) {
		return Maths.arccos(a);
	}

	public static Dataset arctan(final Object a) {
		return Maths.arctan(a);
	}

	public static Dataset toDegrees(final Object a) {
		return Maths.toDegrees(a);
	}

	public static Dataset toRadians(final Object a) {
		return Maths.toRadians(a);
	}

	public static Dataset sinh(final Object a) {
		return Maths.sinh(a);
	}

	public static Dataset cosh(final Object a) {
		return Maths.cosh(a);
	}

	public static Dataset tanh(final Object a) {
		return Maths.tanh(a);
	}

	public static Dataset arcsinh(final Object a) {
		return Maths.arcsinh(a);
	}

	public static Dataset arccosh(final Object a) {
		return Maths.arccosh(a);
	}

	public static Dataset arctanh(final Object a) {
		return Maths.arctanh(a);
	}
	
	/**
	 * @see DatasetUtils.transpose(IDataset a, int... axes)
	 * @param a
	 * @param axes
	 * @return
	 */
	public static Dataset transpose(final IDataset a, int... axes) {
		return DatasetUtils.transpose(a, axes);
	}

	/**
     * Makes a tile of the passed in data with the passed in repetition shape.
     * @param copy
     * @return
     */
	public static Dataset tile(final IDataset copy, int... reps) {
		return DatasetUtils.tile(copy, reps);
	}

	/**
     * Makes an arange(...) using the size of the passed in data.
     * @param copy
     * @return
     */
	public static Dataset arange(final IDataset copy) {
		return DatasetFactory.createRange(IntegerDataset.class, copy.getSize());
	}

	public static Dataset mean(final Dataset data,final int axis) {
		data.squeeze();
		return data.mean(axis);
	}
	
	public static Dataset sum(final Dataset data,final int axis) {
		data.squeeze();
		return data.sum(axis);
	}
	
	public static IDataset slice(final IDataset data,final int[] start,
																   final int[] stop,
																   final int[] step) {
		return data.getSlice(start, stop, step);
	}
	
	public static Dataset stdDev(final Dataset data, final int axis) {
		data.squeeze();
		return data.stdDeviation(axis);
	}
	
	public static Dataset max (final Dataset data, final int axis) {
		data.squeeze();
		return data.max(axis);
	}
	
	public static Dataset min(final Dataset data, final int axis) {
		data.squeeze();
		return data.min(axis);
	}
	
	public static Dataset peakToPeak(final Dataset data, final int axis) {
		data.squeeze();
		return data.peakToPeak(axis);
	}
	
	public static Dataset product(final Dataset data, final int axis) {
		data.squeeze();
		return data.product(axis);
	}
	
	public static Dataset rootMeanSquare(Dataset data, int axis) {
		data.squeeze();
		return data.rootMeanSquare(axis);
	}
	
	public static Dataset median(Dataset data, int axis) {
		data.squeeze();
		return Stats.median(data,axis);
	}
	
	public static Dataset slice(Dataset data, String sliceString) {
		Slice[] slices = Slice.convertFromString(sliceString);

		if (slices.length != data.getRank()) throw new IllegalArgumentException("Invalid string");

		return data.getSlice(slices).squeeze();
	}
	
	public static IDataset squeeze(IDataset data) {
		return data.squeeze();
	}

	public static Dataset reshape(Dataset data, int[] shape) {
		Dataset out = data.clone();
		return out.reshape(shape);
	}
}
