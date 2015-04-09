package intervals;

public class RightOpened extends Interval {
	public RightOpened(double minimum, double maximum, Opening opening) {
		super(minimum, maximum, opening);
		// TODO Auto-generated constructor stub
	}

	public boolean includes(double value) {
		return this.getMinimum() <= value && value < this.getMaximum();
	}
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.getMinimum());
		boolean maximumIncluded = this.includes(interval.getMaximum());
		switch (interval.getOpening()) {
		case BOTH_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case LEFT_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded);
		case RIGHT_OPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded || this.getMaximum() == interval.getMaximum());
		case UNOPENED:
			return (minimumIncluded || this.getMinimum() == interval.getMinimum())
					&& (maximumIncluded);
		default:
			assert false;
			return false;
		}
	}
	public boolean intersectsWith(Interval interval) {
		if (this.getMinimum() == interval.getMaximum()) {
			return interval.getOpening() == Opening.LEFT_OPENED ||
					interval.getOpening() == Opening.UNOPENED;
		}
		if (this.getMaximum() == interval.getMinimum()) {
			return false;
		}
		return this.includes(interval.getMinimum())
				|| this.includes(interval.getMaximum());
	}

	@Override
	public boolean includes(BothOpened bothOpenedInterval) {
		boolean minimumIncluded = this.includes(bothOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(bothOpenedInterval.getMaximum());
		return (minimumIncluded || this.getMinimum() == bothOpenedInterval.getMinimum())
				&& (maximumIncluded || this.getMaximum() == bothOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(LeftOpened leftOpenedInterval) {
		boolean minimumIncluded = this.includes(leftOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(leftOpenedInterval.getMaximum());
		return (minimumIncluded || this.getMinimum() == leftOpenedInterval.getMinimum())
				&& (maximumIncluded);
	}

	@Override
	public boolean includes(RightOpened rightOpenedInterval) {
		boolean minimumIncluded = this.includes(rightOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(rightOpenedInterval.getMaximum());
		return (minimumIncluded || this.getMinimum() == rightOpenedInterval.getMinimum())
				&& (maximumIncluded || this.getMaximum() == rightOpenedInterval.getMaximum());
	}

	@Override
	public boolean includes(UnOpened unOpenedInterval) {
		boolean minimumIncluded = this.includes(unOpenedInterval.getMinimum());
		boolean maximumIncluded = this.includes(unOpenedInterval.getMaximum());
		return (minimumIncluded || this.getMinimum() == unOpenedInterval.getMinimum())
				&& (maximumIncluded);
	}
}


